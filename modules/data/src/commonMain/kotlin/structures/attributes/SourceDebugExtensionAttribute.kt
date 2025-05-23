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

/**
 * Describes a SourceDebugExtension attribute structure.
 */
class SourceDebugExtensionAttribute(private val attributeLength: Int, classFile: ClassFile) : AttributeInfo(classFile) {

    /**
     * Text in the SourceDebugExtension attribute
     */
    var string: String = ""

    override fun readData(input: DataInput) {
        val byteArray = input.readByteArray(attributeLength)
        string = byteArray.decodeToString()
    }

    override fun writeData(output: DataOutput) {
        output.write(string.encodeToByteArray())
    }

    override fun getAttributeLength(): Int = string.encodeToByteArray().size

    override val debugInfo: String
        get() = "with ${string.length} characters"

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        const val ATTRIBUTE_NAME = "SourceDebugExtension"
    }

}
