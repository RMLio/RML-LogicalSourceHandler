package be.ugent.mmlab.rml.logicalsourcehandler.configuration;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andimou on 9/22/16.
 */
public class LogicalSourceConfiguration {

    // Log
    private static final Logger log =
            LoggerFactory.getLogger(LogicalSourceConfiguration.class);

    private static final Options cliOptions = generateCLIOptions();

    private static Options generateCLIOptions() {
        Options cliOptions = new Options();

        cliOptions.addOption("h", "help", false,
                "show this help message");
        cliOptions.addOption("m", "mapping document", true,
                "the URI of the mapping file (required)");
        cliOptions.addOption("o", "output file", true,
                "the URI of the output file (required)");
        cliOptions.addOption("tm", "Triples Map", true,
                "Triples Map to be executed.");
        cliOptions.addOption("b", "base IRI", true,
                "Base IRI of the mapping document.");
        return cliOptions;
    }

    public static CommandLine parseArguments(String[] args) throws ParseException {

        CommandLineParser cliParser = new GnuParser();
        return cliParser.parse(getCliOptions(), args);
    }

    public static Options getCliOptions() {
        return cliOptions;
    }

    public static void displayHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Logical Source Handler ", getCliOptions());
        System.exit(1);
    }
}
