package run;

import things.*;
import utilities.Action;

public class Story {
    public static void main(String[] args) {
        StoryCharacter Karlsson = new StoryCharacter("Карлсон");
        StoryCharacter Lillebror = new StoryCharacter("Малыш");
        VacuumCleaner vacuumCleaner = new VacuumCleaner(new Dust(), new Stamp());
        Floor floor = new Floor();
        Wind wind = new Wind();
        vacuumCleaner.placeOn(floor);
        // Карлсон навалился животом на пылесос и вцепился в его ручку.
        Karlsson.interactWith(vacuumCleaner, Action.FALL, Action.GRAB);
        // Малыш удивился, что Карлсон, как маленький играет в такие детские игры, но смотреть на это было все же забавно.
        Lillebror.wonder(Karlsson);
        // Карлсон открыл пылесос и высыпал все, что в нем было, прямо на ковер.
        Karlsson.interactWith(vacuumCleaner, Action.OPEN);
        // Получилась большая куча серо-черной пыли.
        // Больше он уже не смог ничего добавить,
        // потому что в открытое окно ворвался ветер,
        wind.blow(floor, Karlsson, Lillebror);
        // взметнул пыль,
        // она забилась Карлсону в нос,
        // и он чихнул.
        // От его чиханья пыль снова взметнулась,
        // над полом покружил маленький разноцветный квадратик
        // и упал к ногам Малыша.
        // Малыш обдул пыль со своей драгоценной марки --
        // он был совершенно счастлив.
        // Вдруг Карлсон еще раз чихнул,
        // и с пола снова поднялось целое облако пыли.
    }
}
