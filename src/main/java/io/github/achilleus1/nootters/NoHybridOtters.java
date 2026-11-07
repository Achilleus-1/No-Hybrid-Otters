package io.github.achilleus1.nootters;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobSpawnType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;

@Mod(NoHybridOtters.MOD_ID)
public final class NoHybridOtters {
    public static final String MOD_ID = "no_hybrid_otters";
    public static final ModConfigSpec.BooleanValue DISABLE_OTTERS;
    public static final ModConfigSpec CONFIG;
    private static final ResourceLocation OTTER = ResourceLocation.fromNamespaceAndPath("hybrid_aquatic", "otter");

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        DISABLE_OTTERS = builder
                .comment("Prevent natural and world-generation Hybrid Aquatic Otter spawns. Existing Otters, breeding, spawn eggs, and commands are kept.")
                .define("disableNaturalOtterSpawns", true);
        CONFIG = builder.build();
    }

    public NoHybridOtters(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, CONFIG, MOD_ID + "-common.toml");
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, NoHybridOtters::checkSpawn);
    }

    private static void checkSpawn(MobSpawnEvent.SpawnPlacementCheck event) {
        var reason = event.getSpawnType();
        if ((reason == MobSpawnType.NATURAL || reason == MobSpawnType.CHUNK_GENERATION)
                && OTTER.equals(BuiltInRegistries.ENTITY_TYPE.getKey(event.getEntityType()))
                && DISABLE_OTTERS.get()) {
            event.setResult(MobSpawnEvent.SpawnPlacementCheck.Result.FAIL);
        }
    }
}
