package dandin87.extrashields.object;

import me.crimsondawn45.fabricshieldlib.object.FabricShield;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.Hand;

public class NightShield extends FabricShield
{
    public NightShield(Settings settings, int cooldownTicks, int durability, Tag.Identified<Item> planks)
    {
        super(settings, cooldownTicks, durability, planks);
    }

    @Override
    public void onBlockDamage(LivingEntity defender, DamageSource source, float amount, Hand hand, ItemStack shield)
    {
        //Make enemies that attack you Glow
        if(source.getAttacker() instanceof LivingEntity)
        {
            LivingEntity attacker = (LivingEntity) source.getAttacker();

            if(attacker.isOnGround())
            {
                attacker.setGlowing(true);
            }
        }
    }

    @Override
    public void whileBlocking(LivingEntity defender, Hand hand, ItemStack shield)
    {
        //Give the holder Glow while blocking
        defender.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2, 0, true, true));
    }

    @Override
    public void whileHolding(LivingEntity defender, boolean blocking, Hand hand, ItemStack shield)
    {
        //If the holder is not blocking give them Night Vision
        if(!blocking)
        {
            defender.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 4, 1, true, true));
        }
    }
}