package mekanism.common.registration.impl;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import mekanism.common.registration.WrappedDatapackDeferredRegister;
import net.neoforged.neoforge.common.world.StructureModifier;
import net.neoforged.neoforge.registries.ForgeRegistries;

public class StructureModifierSerializerDeferredRegister extends WrappedDatapackDeferredRegister<StructureModifier> {

    public StructureModifierSerializerDeferredRegister(String modid) {
        super(modid, ForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, ForgeRegistries.Keys.STRUCTURE_MODIFIERS);
    }

    public <T extends StructureModifier> StructureModifierSerializerRegistryObject<T> register(String name, Supplier<Codec<T>> sup) {
        return register(name, sup, StructureModifierSerializerRegistryObject::new);
    }
}