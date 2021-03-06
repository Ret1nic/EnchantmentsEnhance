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

package org.pixeltime.enchantmentsenhance.manager.modular;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.pixeltime.enchantmentsenhance.compatibility.UnsafeGlow;
import org.pixeltime.enchantmentsenhance.interfaces.GlowItem;

public class GlowItem_Unsafe implements GlowItem {

    private UnsafeGlow inst;

    public GlowItem_Unsafe() {
        inst = UnsafeGlow.Factory.create();
        inst.getWrapper(); // 服务器启动后就注册，防止 lazy 造成不发光
    }

    @NotNull
    @Override
    public ItemStack addGlow(@NotNull ItemStack item) {
        return inst.addGlow(item);
    }
}
