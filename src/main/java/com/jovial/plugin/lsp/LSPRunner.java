package com.jovial.plugin.lsp;

import com.jovial.AST.ASTModel;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.sonar.api.batch.fs.InputFile;

/**
 * Placeholder for language server integration.
 * Currently it simply reads the file and builds a trivial AST model.
 */
public final class LSPRunner {
    private LSPRunner() {}

    public static ASTModel parse(InputFile file) {
        try {
            List<String> lines = Files.readAllLines(file.path());
            return ASTModel.fromLines(lines);
        } catch (IOException e) {
            return null;
        }
    }
}
