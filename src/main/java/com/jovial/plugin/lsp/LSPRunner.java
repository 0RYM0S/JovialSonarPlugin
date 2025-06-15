package com.jovial.plugin.lsp;

import com.jovial.AST.ASTModel;
import org.sonar.api.batch.fs.InputFile;

/**
 * Stub for communicating with the external "jovialserver" language server. In a
 * real implementation this class would send the file contents to the server and
 * receive a parsed AST. For now it simply returns {@code null}.
 */
public class LSPRunner {

    private LSPRunner() {
        // utility class
    }

    /**
     * Parse the given file using the external language server.
     *
     * @param file Jovial source file
     * @return parsed AST or {@code null} if parsing failed
     */
    public static ASTModel parseAST(InputFile file) {
        // TODO connect to jovialserver via LSP and return a real AST model
        return null;
    }
}
