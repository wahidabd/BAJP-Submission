package com.wahidabd.bajpsubmussion3.utils

import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.tv.DataTv

object DataDummy {
    fun generateDummyMovie(): ArrayList<DataMovie>{
        val movie = ArrayList<DataMovie>()

        movie.add(
            DataMovie(
                508943,
                "Luca",
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
                "/uAQrHntCccFpvxp75XdQgqexlJd.jpg",
                "2021-06-17"
            )
        )

        movie.add(
            DataMovie(
                581726,
                "Infinite",
                "Evan McCauley has skills he never learned and memories of places he has never visited. Self-medicated and on the brink of a mental breakdown, a secret group that call themselves “Infinites” come to his rescue, revealing that his memories are real.",
                "/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg",
                "/wjQXZTlFM3PVEUmKf1sUajjygqT.jpg",
                "2021-09-08"
            )
        )

        movie.add(
            DataMovie(
                520763,
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "/z2UtGA1WggESspi6KOXeo66lvLx.jpg",
                "2021-05-21"
            )
        )

        movie.add(
            DataMovie(
                385128,
                "F9",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg",
                "2021-05-19"
            )
        )

        movie.add(
            DataMovie(
                337404,
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
                "2021-05-26"
            )
        )

        movie.add(
            DataMovie(
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                "2021-04-22"
            )
        )

        movie.add(
            DataMovie(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "2021-04-07"
            )
        )

        movie.add(
            DataMovie(
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                "2021-05-25"
            )
        )

        movie.add(
            DataMovie(
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                "2021-03-24"
            )
        )

        movie.add(
            DataMovie(
                615457,
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "2021-03-26"
            )
        )

        return movie
    }

    fun generateDummyTv(): ArrayList<DataTv> {
        val tv = ArrayList<DataTv>()

        tv.add(
            DataTv(
                84958,
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "/wr7nrzDrpGCEgYnw15jyAB59PtZ.jpg",
                "2021-06-09"
            )
        )

        tv.add(
            DataTv(
                76669,
                "Elite",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                "/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "/1qOA3kMtQO8bjnW8M2smjA8tp10.jpg",
                "2018-10-05"
            )
        )

        tv.add(
            DataTv(
                119243,
                "iCarly",
                "Ten years after signing off of one of TV's most iconic shows, Carly, Spencer, and Freddie are back, navigating the next chapter of their lives, facing the uncertainties of life in their twenties.",
                "/s5k4GqTUGXeUdScNrjpYfiQLKHI.jpg",
                "/5b5ZZGECl4FLDBKn3zJ6w6GBPRg.jpg",
                "2021-06-17"
            )
        )

        tv.add(
            DataTv(
                60625,
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                "/eV3XnUul4UfIivz3kxgeIozeo50.jpg",
                "2013-12-02"
            )
        )

        tv.add(
            DataTv(
                114868,
                "Record of Ragnarok",
                "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
                "/kTs2WNZOukpWdNhoRlH94pSJ3xf.jpg",
                "/iq5L971DFW1SwLJdvl7OpPI1QeZ.jpg",
                "2021-06-17"
            )
        )

        tv.add(
            DataTv(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                "2017-09-25"
            )
        )

        tv.add(
            DataTv(
                95057,
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "/pPKiIJEEcV0E1hpVcWRXyp73ZpX.jpg",
                "2021-02-23"
            )
        )

        tv.add(DataTv(
            95557,
            "Invincible",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage Invincible",
            "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
            "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
            "2021-03-26"
            )
        )

        tv.add(
            DataTv(
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
            )
        )

        tv.add(
            DataTv(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "2014-10-07"
            )
        )

        return tv
    }

    fun generateDummyFavorite(): ArrayList<DataFavorite> {
        val favorite = ArrayList<DataFavorite>()

        favorite.add(
            DataFavorite(
                508943,
                "Luca",
                "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
                "/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg",
                "2021-06-17",
                "MOVIE"
            )
        )

        favorite.add(
            DataFavorite(
                520763,
                "A Quiet Place Part II",
                "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "/z2UtGA1WggESspi6KOXeo66lvLx.jpg",
                "2021-05-21"
            )
        )

        favorite.add(
            DataFavorite(
                581726,
                "Infinite",
                "/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg",
                "/wjQXZTlFM3PVEUmKf1sUajjygqT.jpg",
                "2021-09-08"
            )
        )

        favorite.add(
            DataFavorite(
                385128,
                "F9","/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg",
                "2021-05-19",
                "MOVIE"
            )
        )

        favorite.add(
            DataFavorite(
                337404,
                "Cruella",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
                "2021-05-26",
                "MOVIE"
            )
        )

        return favorite
    }
}