package io.github.vrcmteam.vrcm.network.extensions

import io.github.vrcmteam.vrcm.network.supports.VRCApiException
import io.ktor.client.statement.*

suspend inline fun <reified T> HttpResponse.ifOK(mapping: HttpResponse.() -> T): Result<T> =
    if (status.value == 200) {
        Result.success(this).map(mapping)
    } else {
        Result.failure(
            VRCApiException(
                message = status.description,
                bodyText = bodyAsText(),
                code = status.value
            )
        )
    }