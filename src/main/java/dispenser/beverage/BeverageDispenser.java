package dispenser.beverage;

import dispenser.beverage.drinks.BeverageEnum;
import dispenser.beverage.machine.BeverageMachine;
import dispenser.beverage.machine.BeverageMachineBuilder;

public class BeverageDispenser {

    public static void main(String[] args) {
        BeverageDispenser beverageDispenser = new BeverageDispenser();
        beverageDispenser.testOne(1);
        beverageDispenser.waitSomeTime();
        beverageDispenser.testOne(2);
        beverageDispenser.waitSomeTime();
        beverageDispenser.testOne(4);
        beverageDispenser.waitSomeTime();
        beverageDispenser.testOne(8);

    }
    private void waitSomeTime(){
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }
    private void testOne(int nums){
        System.out.println("Starting with " + nums + " dispensers" );
        BeverageMachine beverageMachine = new BeverageMachineBuilder()
                .simpleBuilder().withDispensers(nums).withFilledContainers().build();
        //beverageMachine.getLevels();
        beverageMachine.dispense(BeverageEnum.BLACK_TEA);
        beverageMachine.dispense(BeverageEnum.GINGER_TEA);
        beverageMachine.dispense(BeverageEnum.GREEN_TEA);
        beverageMachine.dispense(BeverageEnum.HOT_WATER);
        beverageMachine.dispense(BeverageEnum.HOT_MILK);
        beverageMachine.dispense(BeverageEnum.GREEN_TEA);
        beverageMachine.dispense(BeverageEnum.HOT_WATER);
        beverageMachine.dispense(BeverageEnum.GREEN_TEA);
        beverageMachine.dispense(BeverageEnum.GINGER_TEA);
        beverageMachine.dispense(BeverageEnum.HOT_WATER);
        beverageMachine.dispense(BeverageEnum.GREEN_TEA);
        beverageMachine.dispense(BeverageEnum.GINGER_TEA);
    }


}
