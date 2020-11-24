package tomekcz.mods.skyblock.mixins;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public abstract class MixinRender extends Entity{
    public MixinRender(World worldIn) {
        super(worldIn);
    }

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void onDeath(DamageSource cause,CallbackInfo ci) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(cause.toString()));
    }
}
