package mekanism.common.integration.energy.forgeenergy;

import java.util.Collection;
import java.util.Set;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.common.config.MekanismConfig;
import mekanism.common.config.value.CachedValue;
import mekanism.common.integration.energy.IEnergyCompat;
import mekanism.common.util.CapabilityUtils;
import mekanism.common.util.UnitDisplayUtils.EnergyUnit;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

@NothingNullByDefault
public class ForgeEnergyCompat implements IEnergyCompat {

    @Override
    public Capability<IEnergyStorage> getCapability() {
        return Capabilities.ENERGY;
    }

    @Override
    public boolean isUsable() {
        return EnergyUnit.FORGE_ENERGY.isEnabled();
    }

    @Override
    public Collection<CachedValue<?>> getBackingConfigs() {
        return Set.of(MekanismConfig.general.blacklistForge);
    }

    @Override
    public LazyOptional<IEnergyStorage> getHandlerAs(IStrictEnergyHandler handler) {
        return LazyOptional.of(() -> new ForgeEnergyIntegration(handler));
    }

    @Override
    public LazyOptional<IStrictEnergyHandler> getLazyStrictEnergyHandler(ICapabilityProvider provider, @Nullable Direction side) {
        return CapabilityUtils.getCapability(provider, getCapability(), side).lazyMap(ForgeStrictEnergyHandler::new);
    }
}