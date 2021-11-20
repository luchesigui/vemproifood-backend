package br.com.diogomurano.challenge.adapter.externalService

import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.retry.annotation.RetryPredicate

class ServerErrorRetryPredicate : RetryPredicate {

    override fun test(t: Throwable): Boolean =
        when (t) {
            is HttpClientResponseException -> t.status.code >= 500
            else -> true
        }
}