package com.husnainjaved.checkly

import org.hashids.Hashids

class RandomUtils {

    companion object {

        private const val SALT = "42vCnq^7F4wDBSbs"

        fun generateId(position: Int = (0..1000).random()): String =
            Hashids(SALT).encode(position.toLong())
    }
}