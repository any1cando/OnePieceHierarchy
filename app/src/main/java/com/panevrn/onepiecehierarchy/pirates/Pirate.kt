package com.panevrn.onepiecehierarchy.pirates

interface Human {
    val name: String
    val age: Int
}


data class Pirate(
    val id: Int = 0,
    override val name: String,
    override val age: Int,
    val bounty: Long,
    val devilFruit: Boolean = false,
//    val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),  # Возможно потом добавить еше одно поле про информацию дьяволского фрукта
    val crimeHistory: String,
    val destiny: String
) : Human {

    // Самый обычный пират. Начальная награда за голову 0 Белли

    }

//
//
//class KnownPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 30_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Стать сильнее."
//) : Human {
//
//    // Награда за голову пирата не меньше 30 миллионов Белли. Доставить живым или мертвым
//
//    override fun introduce() {
//        println("Я уплыл от родных земель и даже успел немного прославится на других островах. Меня зовут $name. Награда за мою голову $bounty Белли. Увидимся на Гранд Лайн.")
//    }
//
//}
//
//
//class WellKnownPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 100_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Стать сильнее."
//) : Human {
//
//    // Награда за голову пирата не меньше 100 миллионов Белли. Доставить живым или мертвым
//
//    override fun introduce() {
//        println("Я успел прославиться на многих островах, которые находятся на Гранд Лайн. Награда за мою голову растет с каждой секундой.")
//        println("Мне удалось видеть, хоть и краем глаза, но таких сильных людей, каких свет ещё не видывал!")
//        println("Надеюсь, паренек с именем $name достигнет такого же уровня. Ой, это же я!")
//        println("Мне $age. Награда за мою голову не может сравниться с наградой Йонко в нашем мире, однако она уже немаленькая. Целых $bounty Белли!")
//    }
//
//}
//
//
//class BigPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 500_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Стать сильнее."
//) : Human {
//
//    // Награда за голову пирата не меньше 500 миллионов Белли. Доставить живым или мертвым
//
//    override fun introduce() {
//        println("Вряд ли я увижу что-то новое. Я овладел волей вооружения и наблюдения на неплохом уровне. Каждый раз, когда я приплываю на новый остров Гранд Лайн, я нахожу более сильного соперника.")
//        println("Одним из таких был Donki Hot Do Flamingo, один из Шачибукай. Кто упустит возможность посетить Дресс Розу? Я не стал бросать ему вызов. Он слишком опасен и безумен.")
//        println("Учитывая, какой он тиран, вряд ли лица веселящихся людей в этом государстве были настоящими. Мой путь лежит мимо легендарного острова Зоя, ходячего слона, и королевства Большой Мамочки")
//        println("Ограбления, убийства, расправы и ссоры с правительством разных морей - всё это мои заслуги, которые Дозор мне будет еще долго припоминать.")
//        println("На данный момент мне нужно стать сильнее, чтобы просто не умереть. Моё имя $name. А награда за мою голову... Хо-хо, $bounty, черт его возьми, Белли!")
//    }
//
//}
//
//
//class FamousPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 1_000_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Прославиться на весь мир."
//) : Human {
//
//    // Награда за голову пирата не меньше 500 миллионов Белли. Доставить живым или мертвым
//    override fun introduce() {
//        println("Я не помню, сколько людей я убил, прежде чем моя награда стала $bounty Белли. Я окреп на Гранд Лайн, моя воля стала сильнее, но есть люди куда могущественнее меня")
//        println("Я - $name, и моё имя разлетелось по всем уголкам света. А мой возраст... да какая разница. Желание найти Ван Пис растет с каждой победой. Думаю, я смог бы надрать задницу многим сильным людям.")
//        println("К примеру, Катакури, конфетному генералу, или старику Чан Джао, победителю колизея на Гранд Лайн")
//        println("Я наворошил немало дел, и теперь Дозор не жалеет сил, чтобы поймать меня: вице-адмиралы мои постоянные гости.")
//    }
//
//}
//
//
//class LegendPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 2_000_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Стать Йонко."
//) : Human {
//
//    // Награда за голову пирата не меньше 500 миллионов Белли. Доставить живым или мертвым
//
//    override fun introduce() {
//        println("Я стал легендой. Моё имя, $name, знает каждый ребенок, которому на ночь читают сказки о великих пиратах Гранд Лайн.")
//        println("Встретил вживую великих пиратов, к примеру, Эдварда 'Белоуса' Ньюгейта, Рыжего Пирата - Шанкса, нескольких самураев из страны Вано.")
//        println("Я оставил много грязных следов и преступлений в истории этого мира, о которых не скоро забудут!")
//        println("Хоть я и стал чертовски силён, но есть пираты, которые по силе не уступают Богам нашего мира. Моя следующая цель - догнать их по статусу и стать Йонко!")
//        println("Немного похвастаюсь наградой. Вашему вниманию листовка с наградой $bounty Белли.")
//    }
//
//}
//
//
//class Yonko(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 3_000_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Найти Ван Пис."
//) : Human {
//
//    // Награда за голову пирата не меньше 500 миллионов Белли. Доставить живым или мертвым
//
//    override fun introduce() {
//        println("Йонко, Император морей, один из сильнейших - у меня много имён, хоть настоящее и $name. Награда за мою голову - $bounty Белли.")
//        println("Как я этот жалкий мирок успел переворошить за всё время на Гранд Лайн, я больше не боюсь обычных людей.")
//        println("Убить человека - уже не вызывает у меня никаких эмоций, пройтись по головам другим, чтобы добиться своего - да я только усмехнусь.")
//        println("Бесчисленные грабежи, беспорядочные мятежи в государствах и захват территорий!")
//        println("Моё внимание может привлечь только человек с наградой больше 1 000 000 000 Белли, и то, скорее всего, он окажется грязью по сравнению со мной.")
//        println("В этом мире я ищу забавы, ведь остальное мне наскучило.")
//        println("Пришло и моё время стать Королем Пиратов. Ван пис, я иду за тобой!")
//    }
//
//}
//
//
//class KingPirate(
//    override val name: String,
//    override val age: Short,
//    override val bounty: ULong = 3_000_000_000UL,
//    override val devilFruit: Boolean = false,
//    override val devilFruitInformation: MutableMap<String, String> = mutableMapOf(),
//    override val crimeHistory: MutableList<String> = mutableListOf(),
//    override val pirateDestiny: String = "Пить и развлекаться."
//) : Human {
//
//    // Король Пиратов. Награда за голову, по факту, бесценна. Доставить живым или мертвым.
//
//    override fun introduce() {
//        println("Ха-ха-ха-ха-ха!!! Я Король Пиратов, склоните свои головы перед сильнейшим из сильнейших!")
//        println("Награда за мою голову не важна, хоть она и может удивить каждого.")
//        println("Перечислять мои 'заслуги' - бессмысленно, каждый и так слышал о них в пабах или барах на островах Гранд Лайн")
//        println("Попробуйте достать мою голову! Ведь это единственная забава, что осталась в этом мире для меня!")
//        println("Меня зовут $name, и моё имя войдёт в историю этого гребаного и прогнившего мира.")
//    }
//}

