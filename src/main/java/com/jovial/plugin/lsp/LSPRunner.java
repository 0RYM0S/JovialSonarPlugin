package com.jovial.plugin.lsp;

import com.jovial.AST.ASTModel;
import com.jovial.AST.FunctionNode;
import com.jovial.AST.StatementNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

    /**
     * Very small stub simulating a language server.  It reads a file line by line
     * and produces a simple {@link ASTModel} containing a single function where
     * each line becomes a {@link StatementNode}. In the real implementation, this
     * class should communicate with the Python LSP to obtain the parsed AST.
     */
    public final class LSPRunner {

        private LSPRunner() {
            // utility class
        }

        public static ASTModel parseAST(File file) {
            ASTModel model = new ASTModel();
            FunctionNode fn = new FunctionNode(file.getName());
            model.addFunction(fn);

            try (BufferedReader r = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNo = 1;
                while ((line = r.readLine()) != null) {
                    fn.addStatement(new StatementNode(line, lineNo++));
                }
            } catch (IOException e) {
                // In a real implementation, we would log this properly
                e.printStackTrace();
            }

            return model;
        }
    }