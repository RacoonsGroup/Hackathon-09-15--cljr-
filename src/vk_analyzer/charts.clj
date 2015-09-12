(ns vk-analyzer.charts
  (:require [cheshire.core :refer :all]))

(defn get-data[]
  (evaluate-likes-count)
  [28, 48, 40, 19, 86, 27, 50])

(defn evaluate-likes-count "should return array of results by hour" []
  (def response "{\\\"response\\\":{\\\"count\\\":5783,\\\"items\\\":[{\\\"id\\\":60444427,\\\"from_id\\\":-10639516,\\\"owner_id\\\":-10639516,\\\"date\\\":1441923785,\\\"post_type\\\":\\\"post\\\",\\\"text\\\":\\\"\\u041F\\u043E \\u0442\\u0435\\u043B\\u0435\\u0432\\u0438\\u0434\\u0435\\u043D\\u0438\\u044E \\u0433\\u043E\\u0432\\u043E\\u0440\\u044F\\u0442, \\u0447\\u0442\\u043E \\u0438\\u043D\\u0442\\u0435\\u0440\\u043D\\u0435\\u0442 \\u0440\\u0430\\u0437\\u0432\\u0440\\u0430\\u0449\\u0430\\u0435\\u0442 \\u043C\\u043E\\u043B\\u043E\\u0434\\u0435\\u0436\\u044C. \\u041A\\u043E\\u043D\\u0435\\u0447\\u043D\\u043E, \\u043A\\u0443\\u0434\\u0430 \\u0438\\u043D\\u0442\\u0435\\u0440\\u043D\\u0435\\u0442\\u0443 \\u0434\\u043E \\u0442\\u0430\\u043A\\u043E\\u0439 \\u043F\\u043E\\u0437\\u043D\\u0430\\u0432\\u0430\\u0442\\u0435\\u043B\\u044C\\u043D\\u043E\\u0439 \\u0441\\u0435\\u043C\\u0435\\u0439\\u043D\\u043E\\u0439 \\u043F\\u0435\\u0440\\u0435\\u0434\\u0430\\u0447\\u0438. \\\\n\\u0401\\u0431\\u0430\\u043D\\u044B\\u0435 \\u0436\\u0438\\u0432\\u043E\\u0442\\u043D\\u044B\\u0435. \\u041F\\u043E\\u0437\\u043E\\u0440\\u0438\\u0449\\u0435...\\\",\\\"is_pinned\\\":1,\\\"attachments\\\":[{\\\"type\\\":\\\"video\\\",\\\"video\\\":{\\\"id\\\":171400448,\\\"owner_id\\\":-10639516,\\\"title\\\":\\\"\\\\\\\"-\\u0422\\u044B \\u043D\\u0435 \\u0441\\u043E\\u0441\\u0430\\u043B\\u0430 \\u043D\\u0438\\u043A\\u043E\\u0433\\u0434\\u0430?\\\\\\\"  \\u0414\\u041E\\u041C 2\\\",\\\"duration\\\":71,\\\"description\\\":\\\"vk.com\\\\\\/mdk\\\",\\\"date\\\":1441923656,\\\"views\\\":893241,\\\"comments\\\":1086,\\\"photo_130\\\":\\\"https:\\\\\\/\\\\\\/pp.vk.me\\\\\\/c622117\\\\\\/u264247574\\\\\\/video\\\\\\/s_3d5001c8.jpg\\\",\\\"photo_320\\\":\\\"https:\\\\\\/\\\\\\/pp.vk.me\\\\\\/c622117\\\\\\/u264247574\\\\\\/video\\\\\\/l_a8fa11a1.jpg\\\",\\\"photo_800\\\":\\\"https:\\\\\\/\\\\\\/pp.vk.me\\\\\\/c622117\\\\\\/u264247574\\\\\\/video\\\\\\/x_66ebd2db.jpg\\\",\\\"photo_640\\\":\\\"https:\\\\\\/\\\\\\/pp.vk.me\\\\\\/c622117\\\\\\/u264247574\\\\\\/video\\\\\\/l_a8fa11a1.jpg\\\",\\\"access_key\\\":\\\"d277544a11d0a940b3\\\"}}],\\\"post_source\\\":{\\\"type\\\":\\\"vk\\\"},\\\"comments\\\":{\\\"count\\\":2805,\\\"can_post\\\":1},\\\"likes\\\":{\\\"count\\\":52189,\\\"user_likes\\\":0,\\\"can_like\\\":1,\\\"can_publish\\\":1},\\\"reposts\\\":{\\\"count\\\":4382,\\\"user_reposted\\\":0}},{\\\"id\\\":60507285,\\\"from_id\\\":-10639516,\\\"owner_id\\\":-10639516,\\\"date\\\":1442068518,\\\"post_type\\\":\\\"post\\\",\\\"text\\\":\\\"\\u041D\\u0430\\u0441\\u0442\\u043E\\u0439\\u0447\\u0438\\u0432\\u043E\\u0441\\u0442\\u044C\\\",\\\"attachments\\\":[{\\\"type\\\":\\\"photo\\\",\\\"photo\\\":{\\\"id\\\":385495262,\\\"album_id\\\":-7,\\\"owner_id\\\":-10639516,\\\"user_id\\\":100,\\\"photo_75\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/47249\\\\\\/xODgtLsZlc4.jpg\\\",\\\"photo_130\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4724a\\\\\\/oxcR__c2vik.jpg\\\",\\\"photo_604\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4724b\\\\\\/O73H5g1AOj4.jpg\\\",\\\"photo_807\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4724c\\\\\\/CDqf94nx8so.jpg\\\",\\\"photo_1280\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4724d\\\\\\/8xKCaVbXCxo.jpg\\\",\\\"width\\\":901,\\\"height\\\":262,\\\"text\\\":\\\"\\\",\\\"date\\\":1442068219,\\\"post_id\\\":60507285,\\\"access_key\\\":\\\"14411262f1d42d2300\\\"}}],\\\"post_source\\\":{\\\"type\\\":\\\"vk\\\"},\\\"comments\\\":{\\\"count\\\":70,\\\"can_post\\\":1},\\\"likes\\\":{\\\"count\\\":4225,\\\"user_likes\\\":0,\\\"can_like\\\":1,\\\"can_publish\\\":1},\\\"reposts\\\":{\\\"count\\\":180,\\\"user_reposted\\\":0}},{\\\"id\\\":60506524,\\\"from_id\\\":-10639516,\\\"owner_id\\\":-10639516,\\\"date\\\":1442066732,\\\"post_type\\\":\\\"post\\\",\\\"text\\\":\\\"\\u0421\\u0435\\u0433\\u043E\\u0434\\u043D\\u044F \\u0441\\u0432\\u043E\\u0439 \\u0434\\u0435\\u043D\\u044C \\u0440\\u043E\\u0436\\u0434\\u0435\\u043D\\u0438\\u044F \\u043F\\u0440\\u0430\\u0437\\u0434\\u043D\\u0443\\u0435\\u0442 \\u0425\\u0430\\u043D\\u0441 \\u0426\\u0438\\u043C\\u043C\\u0435\\u0440 \\u2014 \\u0441\\u0430\\u043C\\u044B\\u0439 \\u0432\\u043E\\u0441\\u0442\\u0440\\u0435\\u0431\\u043E\\u0432\\u0430\\u043D\\u043D\\u044B\\u0439 \\u043A\\u043E\\u043C\\u043F\\u043E\\u0437\\u0438\\u0442\\u043E\\u0440\\u043E\\u043C \\u0441\\u043E\\u0432\\u0440\\u0435\\u043C\\u0435\\u043D\\u043D\\u043E\\u0441\\u0442\\u0438\\\",\\\"attachments\\\":[{\\\"type\\\":\\\"photo\\\",\\\"photo\\\":{\\\"id\\\":385483257,\\\"album_id\\\":-7,\\\"owner_id\\\":-10639516,\\\"user_id\\\":100,\\\"photo_75\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4722a\\\\\\/yzSYHBgg7YM.jpg\\\",\\\"photo_130\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4722b\\\\\\/dJ1Ey5UIMkM.jpg\\\",\\\"photo_604\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4722c\\\\\\/SrvaslwbAYc.jpg\\\",\\\"photo_807\\\":\\\"https:\\\\\\/\\\\\\/cs7062.vk.me\\\\\\/c7008\\\\\\/v7008182\\\\\\/4722d\\\\\\/Or9OhhfnbsA.jpg\\\",\\\"width\\\":717,\\\"height\\\":430,\\\"text\\\":\\\"\\\",\\\"date\\\":1442062213,\\\"access_key\\\":\\\"835145e17b10acce25\\\"}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":397756214,\\\"owner_id\\\":2000257068,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"The Battle (OST \\\\\\\"\\u0413\\u043B\\u0430\\u0434\\u0438\\u0430\\u0442\\u043E\\u0440\\\\\\\")\\\",\\\"duration\\\":178,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/psv4.vk.me\\\\\\/c4261\\\\\\/u26986872\\\\\\/audios\\\\\\/aa43f1f7288e.mp3?extra=5oZZQw-fJVMpit7U7ngBTQ42ulXZTJbyVhIS5LBwOG6N9qXJPtbtIdOHxyvI7xI8YE54SfHvTt867Rmorjr7QtvK97g0tLvF9-c\\\",\\\"lyrics_id\\\":278336184,\\\"album_id\\\":2,\\\"genre_id\\\":1}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":396438463,\\\"owner_id\\\":2000258701,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"This Land (OST \\\\\\\"\\u041A\\u043E\\u0440\\u043E\\u043B\\u044C \\u041B\\u0435\\u0432\\\\\\\")\\\",\\\"duration\\\":175,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-23v4.vk-cdn.net\\\\\\/p18\\\\\\/1606ea4648b6aa.mp3?extra=KpgbR4zHDYD4HmL6BSb-Q7CxX3idKDYpg0ro6MeTz9Jye2LLhCiFgBttlSGpZu6ZFMIDdsfolObfBI3P-19DOFRUhmtmp111zU4\\\",\\\"lyrics_id\\\":278336120,\\\"album_id\\\":2,\\\"genre_id\\\":18}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":398162783,\\\"owner_id\\\":2000256779,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"CheValiers De Sangreal (OST \\\\\\\"\\u041A\\u043E\\u0434 \\u0414\\u0430 \\u0412\\u0438\\u043D\\u0447\\u0438\\\\\\\")\\\",\\\"duration\\\":249,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-17v4.vk-cdn.net\\\\\\/p14\\\\\\/1cd2582e0dfa8f.mp3?extra=RR9YHz0IEacFvS5phupG6f_6jcKrw88AYY8gRII4P0Glp0oOL6hfc4n34FQ1FurG100BM5IWwHELhiQFux0K15NLkNNaDQE0G0I\\\",\\\"lyrics_id\\\":278336128,\\\"album_id\\\":2,\\\"genre_id\\\":2}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":397547503,\\\"owner_id\\\":2000257621,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Tennessee (OST \\\\\\\"\\u041F\\u0435\\u0440\\u043B \\u0425\\u0430\\u0440\\u0431\\u043E\\u0440\\\\\\\")\\\",\\\"duration\\\":259,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-28v4.vk-cdn.net\\\\\\/p32\\\\\\/6a3c499eceafe6.mp3?extra=KQF5gIK64i1zHxlSQZPHrf5n9VRjGQs1eqYhy9U94RplnsqVO6QfC6l8LGmRoFxoOmaIPxmkG2iDtPvnug466OmAJj8G4Rz8AVQ\\\",\\\"lyrics_id\\\":278336137,\\\"album_id\\\":2,\\\"genre_id\\\":18}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":397837771,\\\"owner_id\\\":2000260035,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Red Warrior (OST \\\\\\\"\\u041F\\u043E\\u0441\\u043B\\u0435\\u0434\\u043D\\u0438\\u0439 \\u0441\\u0430\\u043C\\u0443\\u0440\\u0430\\u0439\\\\\\\")\\\",\\\"duration\\\":236,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-33v4.vk-cdn.net\\\\\\/p11\\\\\\/30ced6ce625f7f.mp3?extra=YgW85zjJ4Locza8ES2CtM86m8lkx7W1uUu16vvcgnlsfTikEKeHZgH9fCZZg2tNQ5meveqROHa3uzMySUeEtYYFckSlAbv5gSXo\\\",\\\"lyrics_id\\\":278336150,\\\"album_id\\\":2,\\\"genre_id\\\":2}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":396830809,\\\"owner_id\\\":2000256941,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Coward (OST \\\\\\\"\\u0418\\u043D\\u0442\\u0435\\u0440\\u0441\\u0442\\u0435\\u043B\\u043B\\u0430\\u0440\\\\\\\")\\\",\\\"duration\\\":506,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-45v4.vk-cdn.net\\\\\\/p17\\\\\\/c5830131c4c77d.mp3?extra=rvOvk2BtIf5keXKbkUT7oJYsWNWHK5_C7ZU9riIrwPdllPMj6Kq69VJCQxOWyrSBsQXypmIxSvHEyz7NYTXEfhhv5hZxhNqwKk8\\\",\\\"lyrics_id\\\":278336157,\\\"album_id\\\":2,\\\"genre_id\\\":2}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":397394915,\\\"owner_id\\\":2000257816,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Discombobulate (OST \\\\\\\"\\u0428\\u0435\\u0440\\u043B\\u043E\\u043A \\u0425\\u043E\\u043B\\u043C\\u0441\\\\\\\")\\\",\\\"duration\\\":220,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-32v4.vk-cdn.net\\\\\\/p6\\\\\\/22d70aba7e5e26.mp3?extra=yOWRwurNdFMAvn2StJfcfHLqaW7f-7vczlPfOGWXOAjzDzCMlzzPQi3YW33Hn4ySKqy94HBTYq9o2364oMq3shNvkHw7SHox68I\\\",\\\"lyrics_id\\\":278336168,\\\"album_id\\\":2,\\\"genre_id\\\":18}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":395993355,\\\"owner_id\\\":2000256831,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Gothams Reckoning (OST \\\\\\\"\\u0422\\u0435\\u043C\\u043D\\u044B\\u0439 \\u0440\\u044B\\u0446\\u0430\\u0440\\u044C\\\\\\\")\\\",\\\"duration\\\":247,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/psv4.vk.me\\\\\\/c6238\\\\\\/u11651137\\\\\\/audios\\\\\\/0009f77389e8.mp3?extra=Zv8RxitV6rZs2uuYNd9bqKDJWTUvLmv-feVDAuV7onWSKF2mCCAzg9TQbeeMpnn7qu1LIu7QNNttfQjEcymFNiXs3BCm6sNlxYY\\\",\\\"lyrics_id\\\":278336203,\\\"album_id\\\":2,\\\"genre_id\\\":18}},{\\\"type\\\":\\\"audio\\\",\\\"audio\\\":{\\\"id\\\":395084888,\\\"owner_id\\\":2000258098,\\\"artist\\\":\\\"Hans Zimmer\\\",\\\"title\\\":\\\"Time (OST \\\\\\\"\\u041D\\u0430\\u0447\\u0430\\u043B\\u043E\\\\\\\")\\\",\\\"duration\\\":275,\\\"date\\\":1442062213,\\\"url\\\":\\\"https:\\\\\\/\\\\\\/cs1-34v4.vk-cdn.net\\\\\\/p20\\\\\\/f2c16796fdc1d6.mp3?extra=FPX4IfP8ApXWjyDvo8ssIH64SI811DD5rG7ifzeHDuxNzMtwyeT6cCGLOjrP_BP4eU90wHTSQvL2BFMY-gdnD3LzKxZ4gdIm0-4\\\",\\\"lyrics_id\\\":278336232,\\\"album_id\\\":2,\\\"genre_id\\\":18}}],\\\"post_source\\\":{\\\"type\\\":\\\"vk\\\"},\\\"comments\\\":{\\\"count\\\":132,\\\"can_post\\\":1},\\\"likes\\\":{\\\"count\\\":2782,\\\"user_likes\\\":0,\\\"can_like\\\":1,\\\"can_publish\\\":1},\\\"reposts\\\":{\\\"count\\\":498,\\\"user_reposted\\\":0}}]}}")
  (println (parse-string response))
)