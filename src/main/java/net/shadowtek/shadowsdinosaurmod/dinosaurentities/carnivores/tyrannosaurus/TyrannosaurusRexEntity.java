package net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.SDMEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TyrannosaurusRexEntity extends TamableAnimal implements GeoEntity {
    public final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final RawAnimation TREX_BITE_ANIM = RawAnimation.begin().thenPlay("trex.attack.bite");


    private boolean isHunting;
    private boolean isHungry;
    private boolean isThursty;
    private boolean isSleeping;

    public TyrannosaurusRexEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        if(pStack.is(Items.BEEF)||pStack.is(Items.PORKCHOP)||pStack.is(Items.MUTTON)||pStack.is(Items.CHICKEN)){
            return true;
        } else return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob mob) {
        return SDMEntities.TYRANNOSAURUS_REX.get().create(pLevel);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "trex_controller",0, this::predicate));
        controllers.add(DefaultAnimations.genericAttackAnimation(this, TREX_BITE_ANIM));

    }
    protected <T extends TyrannosaurusRexEntity>PlayState predicate(final AnimationState<T> event){
        if(event.isMoving()){
            event.getController().setAnimation(RawAnimation.begin().then("trex.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(RawAnimation.begin().then("trex.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

    }

    public static AttributeSupplier.Builder createAttributes()  {
        return Animal.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 100.0)
                .add(Attributes.MAX_HEALTH, 50.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 24.0);


    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0f, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Sheep.class , true));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 20.0f));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0f));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0f));
        this.goalSelector.addGoal(6, new HurtByTargetGoal(this));
        super.registerGoals();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
