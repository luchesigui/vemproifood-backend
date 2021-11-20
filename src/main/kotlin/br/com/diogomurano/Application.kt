package br.com.diogomurano

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.diogomurano")
		.start()
}

