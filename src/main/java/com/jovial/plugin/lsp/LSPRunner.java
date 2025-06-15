package com.jovial.plugin.lsp;

import com.jovial.AST.ASTModel;
import com.jovial.AST.FunctionNode;
import com.jovial.AST.StatementNode;
import org.sonar.api.batch.fs.InputFile;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Placeholder helper that simulates a connection to a language server. In the
 * proof of concept we simply read the contents of a file and build a very naive
 * AST from it. Integration with the real "jovialserver" should replace all the
 * logic here.
 */
public class LSPRunner {

    private LSPRunner() {
        // utility class
    }

    /**
     * Pretends to ask the language server for an AST of the given file.
     *
     * @param file The source file to parse.
     * @return a minimal ASTModel or {@code null} if an error occurs.
     */
    public static ASTModel parseAST(InputFile file) {
        ASTModel model = new ASTModel();
        FunctionNode fn = new FunctionNode(file.filename());
        model.addFunction(fn);

        try {
            Files.readAllLines(file.path()).forEach(line ->
                fn.addStatement(new StatementNode(line.trim()))
            );
            return model;
        } catch (IOException e) {
            return null;
        }
    }

    // TODO: establish a real LSP connection to "jovialserver" and retrieve the
    // AST in a structured JSON format. The returned ASTModel should be built
    // from the data provided by the server rather than heuristically parsing
    // the file locally.
}
