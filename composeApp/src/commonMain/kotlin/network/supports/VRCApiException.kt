package io.github.vrcmteam.vrcm.network.supports

class VRCApiException(override val message: String,val bodyText: String,val code: Int = -1) : RuntimeException(message)