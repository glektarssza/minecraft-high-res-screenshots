package com.glektarssza.high_res_screenshots.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

/**
 * The early-stage mixin initializer.
 */
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class EarlyMixinInitializer
    implements IEarlyMixinLoader, IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        // -- Does nothing!
        return new String[0];
    }

    @Override
    public String getAccessTransformerClass() {
        // -- Does nothing!
        return null;
    }

    @Override
    public String getModContainerClass() {
        // -- Does nothing!
        return null;
    }

    @Override
    public String getSetupClass() {
        // -- Does nothing!
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        // -- Does nothing!
    }

    /**
     * Get the name of the mixin config file.
     *
     * @returns The name of the mixin config file.
     */
    @Override
    public String getMixinConfig() {
        return "mixins.high_res_screenshots.early.json";
    }

    /**
     * Get the list of additional mixins to load based on the loaded mods.
     *
     * @param loadedMods The list of mods currently loaded.
     *
     * @return The list of additional mixins to load based on the loaded mods.
     */
    @Override
    @Nonnull
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<String>();
        // -- Vanilla mixins
        return mixins;
    }
}
