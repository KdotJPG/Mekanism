package mekanism.client.model.baked;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.lib.QuadTransformation;
import mekanism.client.render.lib.QuadTransformation.TextureFilteredTransformation;
import mekanism.common.tile.qio.TileEntityQIORedstoneAdapter;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.Nullable;

@NothingNullByDefault
public class QIORedstoneAdapterBakedModel extends ExtensionBakedModel<Void> {

    private final Lazy<TextureFilteredTransformation> TRANSFORM = Lazy.of(() -> TextureFilteredTransformation.of(
          QuadTransformation.list(
                QuadTransformation.fullbright,
                QuadTransformation.texture(MekanismRenderer.redstoneTorch)
          ), s -> s.getPath().contains("redstone")
    ));

    public QIORedstoneAdapterBakedModel(BakedModel original) {
        super(original);
    }

    @Nullable
    @Override
    public QuadsKey<Void> createKey(QuadsKey<Void> key, ModelData data) {
        return data.has(TileEntityQIORedstoneAdapter.POWERING_PROPERTY) ? key.transform(TRANSFORM) : null;
    }

    @Override
    protected QIORedstoneAdapterBakedModel wrapModel(BakedModel model) {
        return new QIORedstoneAdapterBakedModel(model);
    }
}
