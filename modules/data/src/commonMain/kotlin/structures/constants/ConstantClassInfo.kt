/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.constants

import org.gjt.jclasslib.structures.ClassFile
import org.gjt.jclasslib.structures.ConstantType

/**
 * Describes a CONSTANT_Class_info constant pool data structure.
 */
class ConstantClassInfo(classFile: ClassFile) : ConstantNameInfo(classFile) {
    override val constantType: ConstantType
        get() = ConstantType.CLASS
}
