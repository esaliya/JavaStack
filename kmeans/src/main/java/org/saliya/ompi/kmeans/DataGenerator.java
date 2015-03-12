package org.saliya.ompi.kmeans;

import com.google.common.base.Optional;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DataGenerator {
    private static Options programOptions = new Options();
    static {
        programOptions.addOption("n",true,"Number of points");
        programOptions.addOption("d",true,"Dimensionality");
        programOptions.addOption("k",true,"Number of centers");
        programOptions.addOption("o",true,"Output directory");
    }

    public static void main(String[] args) throws IOException {
        Optional<CommandLine> parserResult = Utils.parseCommandLineArguments(args, programOptions);
        if (!parserResult.isPresent()) {
            System.out.println(Utils.ERR_PROGRAM_ARGUMENTS_PARSING_FAILED);
            new HelpFormatter().printHelp(Utils.PROGRAM_NAME, programOptions);
            return;
        }

        CommandLine cmd = parserResult.get();
        if (!(cmd.hasOption("n") && cmd.hasOption("d") && cmd.hasOption("k") && cmd.hasOption("o"))) {
            System.out.println(Utils.ERR_INVALID_PROGRAM_ARGUMENTS);
            new HelpFormatter().printHelp(Utils.PROGRAM_NAME, programOptions);
            return;
        }

        int n = Integer.parseInt(cmd.getOptionValue("n"));
        int d = Integer.parseInt(cmd.getOptionValue("d"));
        int k = Integer.parseInt(cmd.getOptionValue("k"));
        String outputDir = cmd.getOptionValue("o");

        Path pointsFile = Paths.get(outputDir, "points.bin");
        Path centersFile = Paths.get(outputDir, "centers.bin");

        try (DataOutputStream pointStream = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(pointsFile, StandardOpenOption.CREATE)));
             DataOutputStream centerStream = new DataOutputStream(
                     new BufferedOutputStream(Files.newOutputStream(centersFile, StandardOpenOption.CREATE)))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < d; j++) {
                    double coord = Math.random();
                    pointStream.writeDouble(coord);
                    if (i >=k ) continue;
                    centerStream.writeDouble(coord);
                }
            }
        }


    }
}