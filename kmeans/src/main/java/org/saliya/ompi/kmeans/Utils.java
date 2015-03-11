package org.saliya.ompi.kmeans;

import com.google.common.base.Optional;
import org.apache.commons.cli.*;

public class Utils {
    static final String PROGRAM_NAME = "K-Means";
    static final String ERR_PROGRAM_ARGUMENTS_PARSING_FAILED =  "Argument parsing failed!";
    static final String ERR_INVALID_PROGRAM_ARGUMENTS =  "Invalid program arguments!";
    static final String ERR_EMPTY_FILE_NAME = "File name is null or empty!";

    /**
     * Parse command line arguments
     * @param args Command line arguments
     * @param opts Command line options
     * @return An <code>Optional&lt;CommandLine&gt;</code> object
     */
    public static Optional<CommandLine> parseCommandLineArguments(String [] args, Options opts){

        CommandLineParser optParser = new GnuParser();

        try {
            return Optional.fromNullable(optParser.parse(opts, args));
        } catch (ParseException e) {
            System.out.println(e);
        }
        return Optional.fromNullable(null);
    }
}
