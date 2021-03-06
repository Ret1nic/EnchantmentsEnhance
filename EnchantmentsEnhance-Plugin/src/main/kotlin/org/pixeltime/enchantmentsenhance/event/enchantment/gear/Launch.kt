/*
 *     Copyright (C) 2017-Present 25 (https://github.com/25)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.pixeltime.enchantmentsenhance.event.enchantment.gear

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.util.Vector
import org.pixeltime.enchantmentsenhance.listener.EnchantmentListener
import org.pixeltime.enchantmentsenhance.manager.SettingsManager

class Launch : EnchantmentListener() {
    override fun desc(): Array<String> {
        return arrayOf("A chance to launch the enemy up in the sky!", "有机率把敌人弹上天")
    }

    override fun lang(): Array<String> {
        return arrayOf("弹射")
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    fun onEntityDamage(entityDamageByEntityEvent: EntityDamageByEntityEvent) {
        if (entityDamageByEntityEvent.entity is Player && entityDamageByEntityEvent.damager is Player) {
            val player = entityDamageByEntityEvent.entity as Player
            val player2 = entityDamageByEntityEvent.damager as Player

            try {
                val level = getLevel(player2)
                if (level > 0 && (roll(level))) {
                    player.velocity = Vector(0, SettingsManager.enchant.getInt("launch.$level.height"), 0)
                }
            } catch (ex: Exception) {
            }
        }
    }
}
