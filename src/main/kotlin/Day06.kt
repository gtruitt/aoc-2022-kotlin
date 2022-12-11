@file:Suppress("PackageDirectoryMismatch")
package day06

import head
import tail

tailrec fun lengthAtFirstUniqueWindow(
    transmission: String,
    windowSize: Int,
    windows: Iterable<IndexedValue<String>> = transmission.windowed(windowSize, 1).withIndex()
): Int =
    when (windows.head.value.toSet().size) {
        windowSize -> windows.head.index + windowSize
        else -> lengthAtFirstUniqueWindow(transmission, windowSize, windows.tail)
    }
