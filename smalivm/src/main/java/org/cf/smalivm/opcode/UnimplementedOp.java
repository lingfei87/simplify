package org.cf.smalivm.opcode;

import org.cf.smalivm.context.ExecutionNode;
import org.cf.smalivm.context.HeapItem;
import org.cf.smalivm.context.MethodState;
import org.jf.dexlib2.builder.BuilderInstruction;

class UnimplementedOp extends MethodStateOp {

    private static final String UNKNOWN_TYPE = "?";
    private final boolean canContinue;
    private final boolean canThrow;
    private final int registerA;
    private final boolean setsRegister;

    private final boolean setsResult;

    UnimplementedOp(BuilderInstruction instruction, BuilderInstruction child, boolean canContinue, boolean canThrow,
                    boolean setsResult) {
        this(instruction, child, canContinue, canThrow, setsResult, false, -1);
    }

    UnimplementedOp(BuilderInstruction instruction, BuilderInstruction child, boolean canContinue, boolean canThrow,
                    boolean setsResult, boolean setsRegister, int registerA) {
        super(instruction, canContinue ? new BuilderInstruction[] { child } : new BuilderInstruction[0]);

        this.canContinue = canContinue;
        this.canThrow = canThrow;
        this.setsResult = setsResult;
        this.setsRegister = setsRegister;
        this.registerA = registerA;
    }

    @Override
    public void execute(ExecutionNode node, MethodState mState) {
        if (setsResult) {
            mState.assignResultRegister(HeapItem.newUnknown(UNKNOWN_TYPE));
        }

        if (registerA >= 0) {
            if (setsRegister) {
                mState.assignRegister(registerA, HeapItem.newUnknown(UNKNOWN_TYPE));
            } else {
                mState.readRegister(registerA);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getName());
        if (registerA >= 0) {
            sb.append(" r").append(registerA);
        }
        sb.append(" (unimplmented)");

        return sb.toString();
    }

}
