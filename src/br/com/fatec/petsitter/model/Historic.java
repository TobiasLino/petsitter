package br.com.fatec.petsitter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Historic {
    public static Historic createEmpty() {
        return new Historic();
    }

    public void
    allocate
    (Profissional petsitter, Cliente client, Animal animal) {
        SimpleLogging logger = new SimpleLogging();
        logger.log(formatAllocate(petsitter, client, animal));
    }

    private String formatAllocate
    (Profissional petsitter, Cliente client, Animal animal) {
        String str = new String();
        str += "\t" + petsitter.getName().toUpperCase()
            + " alocado para " + client.getName().toUpperCase()
            + " para o pet:\n" + animal.data() + "\n";
        return str;
    }

    class SimpleLogging {
        FIleManIp fl;

        public SimpleLogging() {
            fl = FIleManIp.open("log", getLogFileName());
        }

        public void log(String toWrite) {
            fl.WriteInFile(formatLog(toWrite));
        }

        private String formatLog(String str) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            return "log " + dateFormat.format(new Date()) + "\n" + str;
        } 

        private String getLogFileName() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
            return "log_" + dateFormat.format(new Date()) + ".txt";
        }
    }
}