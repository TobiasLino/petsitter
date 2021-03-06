package br.com.fatec.petsitter.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {
    private Agenda agenda;

    public static Report create(Agenda agenda) {
        Report report = new Report();
        report.agenda = agenda;
        return report;
    }

    public void writeReportToFile() {
        String filePath = "rel";
        String fileName = defineReportName();

        FIleManIp fl = FIleManIp.open(filePath, fileName);
        fl.checkIfExists();
        fl.WriteInFile(getReport());
    }

    private String defineReportName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyy");
        // O nome do arquivo criado será rel_ + a data atual no formato dia_mes_ano
        // com extensão .txt
        // Exemplo: rel_10_03_2020.txt
        return "rel_" + dateFormat.format(new Date()) + ".txt";
    }

    

    public String getReport() {
        String str = new String();
        MostCommonBreeds mostCommon = new MostCommonBreeds();
        PreferredGenderByRace favouriteGender = new PreferredGenderByRace();

        str += mostCommon.get();
        str += favouriteGender.get();
        return str;
    }


    class MostCommonBreeds {

        public String get() {
            String ret = new String();
            int valor = 1;
            LinkedList<String> breeds =
                    sortByValue(getAllBreeds(agenda.getClients()));
            Iterator<String> breed = breeds.descendingIterator();
            ret += "Racas mais comuns:\n";
            while (breed.hasNext()) {
                ret += "\t" + valor + " - " + breed.next() + "\n";
                valor += 1;
            }
            return ret;
        }
    
        public HashMap<String, Integer> getAllBreeds(HashMap<Integer, People> clientes) {
            HashMap<String, Integer> map = new HashMap<>();
            for (People client : clientes.values()) {
                for (Animal pet : ((Cliente) client).getPets()) {
                    addBreedIntoMap(map, pet.raca);
                }
            }
            return map;
        }
    
        private void addBreedIntoMap(HashMap<String, Integer> map, String raca) {
            if (map.containsKey(raca)) {
                map.replace(raca, (Integer) (map.get(raca) + 1));
            } else {
                map.put(raca, 1);
            }
        }
    
        private LinkedList<String>
        sortByValue(HashMap<String, Integer> map) {
            HashMap<String, Integer> allBreeds = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (k, v) -> k, HashMap::new)
                );
            LinkedList<String> l = new LinkedList<>();
            for (Map.Entry<String, Integer> breed : allBreeds.entrySet()) {
                l.add(breed.getKey());
            }
            return l;
        }
    }


    class PreferredGenderByRace {

        public String get() {
            String ret = new String();
            HashMap<String, HashMap<String, Integer>> map = 
                getTheMostPreferredGenderByRace(agenda.getClients());
            ret += "Genero preferido por raca:\n";
            for (Map.Entry<String, HashMap<String, Integer>> race : map.entrySet()) {
                ret += "\t" + race.getKey() + " - "
                + getTheGenderWithTheGreatestAmount(race.getValue()) + "\n";
            }

            return ret;
        }

        public HashMap<String, HashMap<String, Integer>>
        getTheMostPreferredGenderByRace(HashMap<Integer, People> clientes) {
            HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
            for (People client : clientes.values()) {
                for (Animal pet : ((Cliente) client).getPets()) {
                    addGenderIntoMap(map, pet);
                }
            }
            return map;
        }

        private void
        addGenderIntoMap
        (HashMap<String, HashMap<String, Integer>> map, Animal pet) {
            if (!map.containsKey(pet.raca)) {
                insertNewRace(map, pet);
            } else {
            	insertGenderIntoExistingRace(map.get(pet.raca), pet);
            }
        }

        private void
        insertNewRace
        (HashMap<String, HashMap<String, Integer>> map, Animal pet) {
            HashMap<String, Integer> genders = defineGendersMap();
            genders.replace(pet.genero, 1);
            map.put(pet.raca, genders);
        }

        private HashMap<String, Integer> defineGendersMap() {
            HashMap<String, Integer> genders = new HashMap<>();
            genders.put("male", 0);
            genders.put("female", 0);
            return genders;
        }

        private void
        insertGenderIntoExistingRace
        (HashMap<String, Integer> map, Animal pet) {
            Integer oldQuant = map.get(pet.genero);
            map.put(pet.genero, oldQuant + 1);
        }

        private String getTheGenderWithTheGreatestAmount(HashMap<String, Integer> genders) {
            if (genders.get("male") >= genders.get("female")) {
                return "macho";
            } else {
                return "femea";
            }
        }
    }
}