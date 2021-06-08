package com.wahidabd.bajpsubmission2

import com.wahidabd.bajpsubmission2.model.DataList

object DataDummy {
    fun getMovies(): List<DataList> {
        return listOf(
            DataList(
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "2021-04-07",
                "",
                ""
            ),
            DataList(
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "2021-04-29",
                "",
                ""
            ),
            DataList(
                399566,
                "Godzilla vs. Kong",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "2021-03-24",
                "",
                ""
            )
        )
    }

    fun getDetailMovie(): DataList {
        return DataList(
            460465,
            "Mortal Kombat",
            "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            "/6ELCZlTA5lGUops70hKdB83WJxH.jpg",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "2021-04-07",
            "",
            ""
        )
    }

    fun getTvShows(): List<DataList> {
        return listOf(
            DataList(
                120168,
                "",
                "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "",
                "Who Killed Sara?",
                "2021-03-24"
            ),
            DataList(
                60735,
                "",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "",
                "The Flash",
                "2021-03-24"
            ),
            DataList(
                71712,
                "",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "",
                "The Good Doctor",
                "2017-09-25"
            )
        )
    }

    fun getDetailTvShow(): DataList {
        return DataList(
            120168,
            "",
            "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            "",
            "Who Killed Sara?",
            "2021-03-24"
        )
    }
}