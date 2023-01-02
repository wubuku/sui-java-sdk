package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 *     export type SuiMovePackage = {
 *         // A mapping from module name to disassembled Move bytecode
 *         disassembled: MovePackageContent;
 *     };
 * </pre>
 */
public class SuiMovePackage {
    private MovePackageContent disassembled;

    public SuiMovePackage() {
    }

    public SuiMovePackage(MovePackageContent disassembled) {
        this.disassembled = disassembled;
    }

    public MovePackageContent getDisassembled() {
        return disassembled;
    }

    public void setDisassembled(MovePackageContent disassembled) {
        this.disassembled = disassembled;
    }

    @Override
    public String toString() {
        return "SuiMovePackage{" +
                "disassembled=" + disassembled +
                '}';
    }
}
