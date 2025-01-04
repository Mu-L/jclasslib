/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.bytecode

import org.gjt.jclasslib.io.ByteCodeInput
import org.gjt.jclasslib.io.ByteCodeOutput

/**
 * Base class for instructions that are followed by an immediate unsigned byte.
 * @property isWide Indicates whether the instruction is subject to a wide instruction or not.
 * @property immediateByte Immediate unsigned byte of this instruction.
 */
abstract class ImmediateByteInstruction(opcode: Opcode, override var isWide: Boolean, var immediateByte: Int) : Instruction(opcode), HasWide {

    override val size: Int
        get() = super.size + (if (isWide) 2 else 1)

    override fun read(input: ByteCodeInput) {
        super.read(input)

        immediateByte = if (isWide) {
            input.readUnsignedShort()
        } else {
            input.readUnsignedByte()
        }
    }

    override fun write(output: ByteCodeOutput) {
        super.write(output)

        if (isWide) {
            output.writeShort(immediateByte)
        } else {
            output.writeByte(immediateByte)
        }
    }

}

/**
 * Describes an instruction that is followed by an immediate unsigned byte.
 */
class SimpleImmediateByteInstruction
@JvmOverloads
constructor(opcode: Opcode, isWide: Boolean, immediateByte: Int = 0) : ImmediateByteInstruction(opcode, isWide, immediateByte)
