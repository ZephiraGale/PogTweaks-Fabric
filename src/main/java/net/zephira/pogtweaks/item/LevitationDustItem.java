package net.zephira.pogtweaks.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class LevitationDustItem extends Item {

    public LevitationDustItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient()){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, genRandomDuration()));
        }
        itemStack.decrement(1);
        return super.use(world, user, hand);
        
    }

    private int genRandomDuration() {
        return Random.createLocal().nextBetween(120, 180);
    }
}
