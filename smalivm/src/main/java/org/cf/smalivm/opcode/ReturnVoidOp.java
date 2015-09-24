package org.cf.smalivm.opcode;

import org.cf.smalivm.context.ExecutionNode;
import org.cf.smalivm.context.MethodState;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReturnVoidOp extends MethodStateOp {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(ReturnVoidOp.class.getSimpleName());

    ReturnVoidOp(BuilderInstruction instruction) {
        super(instruction);
    }

    @Override
    public void execute(ExecutionNode node, MethodState mState) {
        //
    }

    @Override
    public String toString() {
        return getName();
    }

}
