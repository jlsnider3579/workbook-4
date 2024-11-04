package com.pluralsight.dealership;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static String contractFile = "contract.txt";

    public void saveContract(Contract contract) {
        try(FileWriter fr = new FileWriter(contractFile, true)) {
            fr.write(contractFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

