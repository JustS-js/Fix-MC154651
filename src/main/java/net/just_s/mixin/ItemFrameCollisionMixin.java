package net.just_s.mixin;

import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemFrame.class)
public abstract class ItemFrameCollisionMixin {
	@Shadow protected abstract AABB getPopBox();

	// Would be easier to @redirect noCollision() to noBlockCollision()
	// But redirects are shamed upon so nuh-uh
	@Inject(at = @At("RETURN"), method = "survives", cancellable = true)
	private void init(CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue()) {
			return;
		}
		// Item frame does not survive. Why?
		ItemFrame frame = (ItemFrame)(Object)this;
		if (frame.level().noBlockCollision(frame, this.getPopBox())) {
			// no block collision detected, so it should have been either boat or shulker
			// (or any other entity with solid box that I don't really care about)
			cir.setReturnValue(true);
		}
	}
}