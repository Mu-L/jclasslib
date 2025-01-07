/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.io.DataInput
import org.gjt.jclasslib.io.DataOutput
import org.gjt.jclasslib.structures.AttributeInfo
import org.gjt.jclasslib.structures.ClassFile
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info

/**

* Describes a SourceFile attribute structure.
 */
class SourceFileAttribute(classFile: ClassFile) : AttributeInfo(classFile) {

    /**
     * Constant pool index of the name for the input file.
     */
    var sourceFileIndex: Int = 0

    /**
     * Returns the constant that is referenced by the [sourceFileIndex] index.
     */
    val sourceFileConstant: ConstantUtf8Info
        get() = classFile.getConstantPoolUtf8Entry(sourceFileIndex)


    override fun readData(input: DataInput) {
        sourceFileIndex = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeShort(sourceFileIndex)
    }

    override fun getAttributeLength(): Int = 2

    override val debugInfo: String
        get() = "inputfileIndex $sourceFileIndex"

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        const val ATTRIBUTE_NAME = "SourceFile"
    }
}
