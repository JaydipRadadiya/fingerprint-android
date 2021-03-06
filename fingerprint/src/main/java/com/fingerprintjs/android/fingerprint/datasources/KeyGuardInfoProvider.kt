package com.fingerprintjs.android.fingerprint.datasources

import android.app.KeyguardManager
import com.fingerprintjs.android.fingerprint.tools.executeSafe


interface KeyGuardInfoProvider {
    fun isPinSecurityEnabled(): Boolean
}

class KeyGuardInfoProviderImpl(
    private val keyguardManager: KeyguardManager
) : KeyGuardInfoProvider {
    override fun isPinSecurityEnabled() = executeSafe(
        { keyguardManager.isKeyguardSecure }, false
    )
}
