package com.example

import com.aliucord.api.SettingsAPI
import com.aliucord.plugins.Plugin
import com.discord.api.guild.GuildFeature
import com.discord.models.guild.Guild
import java.util.*

class FakeBoost : Plugin() {
    
    override fun start() {
        // Logique pour simuler le Boost Niveau 3
        
        // Cible la méthode qui lit les 'features' du serveur
        // et ajoute les fonctionnalités de Boost (comme les bannières)
        patcher.patch(Guild::class.java.getMethod("getFeatures"), patcher.buildPatch {
            it.result<Set<GuildFeature>>().add(GuildFeature.BANNER)
            it.result<Set<GuildFeature>>().add(GuildFeature.ANIMATED_ICON)
        })

        // Cible la méthode qui lit le 'boost level' du serveur
        patcher.patch(Guild::class.java.getMethod("getPremiumTier"), patcher.buildPatch {
            // Force le niveau 3 (maximum)
            it.result(3)
        })

        // On peut ajouter un message de log pour confirmer l'exécution
        // logger.info("FakeBoost is running!")
    }

    override fun stop() {
        // Retire toutes les modifications faites par le plugin
        patcher.unpatchAll()
    }
}
