package run;

import things.*;
import utilities.Action;
import utilities.ScareableStoryCharacterInterface;
import utilities.ScaredException;

public class Story {
    public static void main(String[] args) {
        Story mainStory = new Story();
        mainStory.playStory();
    }

    public void playStory() {
        StoryCharacter Karlsson = new StoryCharacter("Карлсон");
        StoryCharacter Lillebror = new StoryCharacter("Малыш");

        Room room = new Room("Комната Малыша", Karlsson, Lillebror);
        Stamp stamp = new Stamp("Марка с изображением Красной Шапочки");
        VacuumCleaner vacuumCleaner = new VacuumCleaner(new Dust(), stamp);
        Floor floor = new Floor(room);
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
        Wind wind = new Wind();
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
        // Но Малыш его не слушал.
        Album album = new Album("Альбом Малыша с марками");
        Lillebror.putIntoAlbum(stamp, album);
        // Он хотел только одного — как можно скорее наклеить Красную Шапочку в альбом.
        // А Карлсон стоял в облаке пыли и чихал.
        // Он всё чихал и чихал до тех пор, пока не «расчихал» пыль по всей комнате.
        // Но Малыш не мог оторваться от своей марки.
        // Он её уже наклеил и сейчас любовался ею — до чего хороша!
        // Малыш отложил альбом.
        Lillebror.remember(new Story() {
            public void playStory() {
                Room pastRoom = new Room(room);
                Roof roof = new Roof("Крыша Карлсона");
                pastRoom.transfer(roof, pastRoom.getLocationPeople());
                // Полететь с Карлсоном на крышу — об этом можно было только мечтать!
                // Лишь однажды довелось ему побывать у Карлсона, в его маленьком домике на крыше.
                class ScareableStoryCharacter extends StoryCharacter implements ScareableStoryCharacterInterface {
                    public ScareableStoryCharacter(String name) {
                        super(name);
                    }
                }
                ScareableStoryCharacter Mother = new ScareableStoryCharacter("Мама");
                Mother.check(pastRoom, roof, Lillebror);
            }
            // Но в тот раз мама почему-то ужасно испугалась и вызвала пожарников.
        });
    }
}
