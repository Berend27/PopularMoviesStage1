package com.udacity.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import static android.content.ContentValues.TAG;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {
    private int mNumberItems;

    final private PosterItemClickListener mOnClickListener;

    protected String json = "{\"page\":1,\"total_results\":19847,\"total_pages\":993,\"results\":[{\"vote_count\":136,\"id\":335983,\"video\":false,\"vote_average\":6.4,\"title\":\"Venom\",\"popularity\":324.891,\"poster_path\":\"\\/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg\",\"original_language\":\"en\",\"original_title\":\"Venom\",\"genre_ids\":[27,878,28,53],\"backdrop_path\":\"\\/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg\",\"adult\":false,\"overview\":\"When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego “Venom” to save his life.\",\"release_date\":\"2018-10-03\"},{\"vote_count\":2326,\"id\":363088,\"video\":false,\"vote_average\":6.9,\"title\":\"Ant-Man and the Wasp\",\"popularity\":195.01,\"poster_path\":\"\\/rv1AWImgx386ULjcf62VYaW8zSt.jpg\",\"original_language\":\"en\",\"original_title\":\"Ant-Man and the Wasp\",\"genre_ids\":[28,12,35,878,10751,10749],\"backdrop_path\":\"\\/6P3c80EOm7BodndGBUAJHHsHKrp.jpg\",\"adult\":false,\"overview\":\"Just when his time under house arrest is about to end, Scott Lang puts again his freedom at risk to help Hope van Dyne and Dr. Hank Pym dive into the quantum realm and try to accomplish, against time and any chance of success, a very dangerous rescue mission.\",\"release_date\":\"2018-07-04\"},{\"vote_count\":905,\"id\":439079,\"video\":false,\"vote_average\":5.9,\"title\":\"The Nun\",\"popularity\":139.636,\"poster_path\":\"\\/sFC1ElvoKGdHJIWRpNB3xWJ9lJA.jpg\",\"original_language\":\"en\",\"original_title\":\"The Nun\",\"genre_ids\":[27,9648,53],\"backdrop_path\":\"\\/fgsHxz21B27hOOqQBiw9L6yWcM7.jpg\",\"adult\":false,\"overview\":\"When a young nun at a cloistered abbey in Romania takes her own life, a priest with a haunted past and a novitiate on the threshold of her final vows are sent by the Vatican to investigate. Together they uncover the order’s unholy secret. Risking not only their lives but their faith and their very souls, they confront a malevolent force in the form of the same demonic nun that first terrorized audiences in “The Conjuring 2,” as the abbey becomes a horrific battleground between the living and the damned.\",\"release_date\":\"2018-09-05\"},{\"vote_count\":8483,\"id\":299536,\"video\":false,\"vote_average\":8.3,\"title\":\"Avengers: Infinity War\",\"popularity\":136.821,\"poster_path\":\"\\/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Infinity War\",\"genre_ids\":[12,878,28,14],\"backdrop_path\":\"\\/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg\",\"adult\":false,\"overview\":\"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\"release_date\":\"2018-04-25\"},{\"vote_count\":2008,\"id\":348350,\"video\":false,\"vote_average\":6.7,\"title\":\"Solo: A Star Wars Story\",\"popularity\":135.508,\"poster_path\":\"\\/3IGbjc5ZC5yxim5W0sFING2kdcz.jpg\",\"original_language\":\"en\",\"original_title\":\"Solo: A Star Wars Story\",\"genre_ids\":[28,12,878,80,37,10749],\"backdrop_path\":\"\\/96B1qMN9RxrAFu6uikwFhQ6N6J9.jpg\",\"adult\":false,\"overview\":\"Through a series of daring escapades deep within a dark and dangerous criminal underworld, Han Solo meets his mighty future copilot Chewbacca and encounters the notorious gambler Lando Calrissian.\",\"release_date\":\"2018-05-15\"},{\"vote_count\":37,\"id\":507569,\"video\":false,\"vote_average\":5.9,\"title\":\"The Seven Deadly Sins: Prisoners of the Sky\",\"popularity\":114.026,\"poster_path\":\"\\/r6pPUVUKU5eIpYj4oEzidk5ZibB.jpg\",\"original_language\":\"ja\",\"original_title\":\"The Seven Deadly Sins: Prisioneros del Cielo\",\"genre_ids\":[28,12,14,16],\"backdrop_path\":\"\\/uKwOX7MtKlAaGeCQe6c4jc1vZpj.jpg\",\"adult\":false,\"overview\":\"Traveling in search of the rare ingredient, “sky fish”  Meliodas and Hawk arrive at a palace that floats above the clouds. The people there are busy preparing a ceremony, meant to protect their home from a ferocious beast that awakens once every 3,000 years. But before the ritual is complete, the Six Knights of Black—a Demon Clan army—removes the seal on the beast, threatening the lives of everyone in the Sky Palace.\",\"release_date\":\"2018-08-18\"},{\"vote_count\":414,\"id\":346910,\"video\":false,\"vote_average\":5.3,\"title\":\"The Predator\",\"popularity\":104.848,\"poster_path\":\"\\/wMq9kQXTeQCHUZOG4fAe5cAxyUA.jpg\",\"original_language\":\"en\",\"original_title\":\"The Predator\",\"genre_ids\":[27,878,28,35],\"backdrop_path\":\"\\/f4E0ocYeToEuXvczZv6QArrMDJ.jpg\",\"adult\":false,\"overview\":\"From the outer reaches of space to the small-town streets of suburbia, the hunt comes home. Now, the universe’s most lethal hunters are stronger, smarter and deadlier than ever before, having genetically upgraded themselves with DNA from other species. When a young boy accidentally triggers their return to Earth, only a ragtag crew of ex-soldiers and a disgruntled science teacher can prevent the end of the human race.\",\"release_date\":\"2018-09-13\"},{\"vote_count\":3713,\"id\":351286,\"video\":false,\"vote_average\":6.5,\"title\":\"Jurassic World: Fallen Kingdom\",\"popularity\":103.537,\"poster_path\":\"\\/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg\",\"original_language\":\"en\",\"original_title\":\"Jurassic World: Fallen Kingdom\",\"genre_ids\":[28,12,878,27],\"backdrop_path\":\"\\/3s9O5af2xWKWR5JzP2iJZpZeQQg.jpg\",\"adult\":false,\"overview\":\"Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again.\",\"release_date\":\"2018-06-06\"},{\"vote_count\":8377,\"id\":284054,\"video\":false,\"vote_average\":7.4,\"title\":\"Black Panther\",\"popularity\":99.884,\"poster_path\":\"\\/uxzzxijgPIY7slzFvMotPv8wjKA.jpg\",\"original_language\":\"en\",\"original_title\":\"Black Panther\",\"genre_ids\":[28,12,14,878],\"backdrop_path\":\"\\/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg\",\"adult\":false,\"overview\":\"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.\",\"release_date\":\"2018-02-13\"},{\"vote_count\":879,\"id\":447200,\"video\":false,\"vote_average\":6.1,\"title\":\"Skyscraper\",\"popularity\":83.881,\"poster_path\":\"\\/5LYSsOPzuP13201qSzMjNxi8FxN.jpg\",\"original_language\":\"en\",\"original_title\":\"Skyscraper\",\"genre_ids\":[28,53,18],\"backdrop_path\":\"\\/oMKFQmoVgB69fyXfSMu0lGlHJP2.jpg\",\"adult\":false,\"overview\":\"Framed and on the run, a former FBI agent must save his family from a blazing fire in the world's tallest building.\",\"release_date\":\"2018-07-11\"},{\"vote_count\":917,\"id\":442249,\"video\":false,\"vote_average\":5.9,\"title\":\"The First Purge\",\"popularity\":73.903,\"poster_path\":\"\\/litjsBoiydO6JlO70uOX4N3WnNL.jpg\",\"original_language\":\"en\",\"original_title\":\"The First Purge\",\"genre_ids\":[28,878,53,27],\"backdrop_path\":\"\\/r4clWIxKeWoqrHspQP0XunuUmB7.jpg\",\"adult\":false,\"overview\":\"To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation.\",\"release_date\":\"2018-07-04\"},{\"vote_count\":704,\"id\":400155,\"video\":false,\"vote_average\":6.9,\"title\":\"Hotel Transylvania 3: Summer Vacation\",\"popularity\":73.731,\"poster_path\":\"\\/gjAFM4xhA5vyLxxKMz38ujlUfDL.jpg\",\"original_language\":\"en\",\"original_title\":\"Hotel Transylvania 3: Summer Vacation\",\"genre_ids\":[10751,14,35,16],\"backdrop_path\":\"\\/m03jul0YdVEOFXEQVUv6pOVQYGL.jpg\",\"adult\":false,\"overview\":\"Dracula, Mavis, Johnny and the rest of the Drac Pack take a vacation on a luxury Monster Cruise Ship, where Dracula falls in love with the ship’s captain, Ericka, who’s secretly a descendant of Abraham Van Helsing, the notorious monster slayer.\",\"release_date\":\"2018-06-28\"},{\"vote_count\":5349,\"id\":383498,\"video\":false,\"vote_average\":7.5,\"title\":\"Deadpool 2\",\"popularity\":71.25,\"poster_path\":\"\\/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg\",\"original_language\":\"en\",\"original_title\":\"Deadpool 2\",\"genre_ids\":[28,35,878],\"backdrop_path\":\"\\/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg\",\"adult\":false,\"overview\":\"Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.\",\"release_date\":\"2018-05-15\"},{\"vote_count\":1756,\"id\":353081,\"video\":false,\"vote_average\":7.3,\"title\":\"Mission: Impossible - Fallout\",\"popularity\":63.312,\"poster_path\":\"\\/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible - Fallout\",\"genre_ids\":[12,28,53],\"backdrop_path\":\"\\/a9fRqsl6P27qxbDSb4pBXNv9Fwl.jpg\",\"adult\":false,\"overview\":\"When an IMF mission ends badly, the world is faced with dire consequences. As Ethan Hunt takes it upon himself to fulfill his original briefing, the CIA begin to question his loyalty and his motives. The IMF team find themselves in a race against time, hunted by assassins while trying to prevent a global catastrophe.\",\"release_date\":\"2018-07-13\"},{\"vote_count\":9401,\"id\":102899,\"video\":false,\"vote_average\":7.1,\"title\":\"Ant-Man\",\"popularity\":62.717,\"poster_path\":\"\\/D6e8RJf2qUstnfkTslTXNTUAlT.jpg\",\"original_language\":\"en\",\"original_title\":\"Ant-Man\",\"genre_ids\":[878,28,12],\"backdrop_path\":\"\\/kvXLZqY0Ngl1XSw7EaMQO0C1CCj.jpg\",\"adult\":false,\"overview\":\"Armed with the astonishing ability to shrink in scale but increase in strength, master thief Scott Lang must embrace his inner-hero and help his mentor, Doctor Hank Pym, protect the secret behind his spectacular Ant-Man suit from a new generation of towering threats. Against seemingly insurmountable obstacles, Pym and Lang must plan and pull off a heist that will save the world.\",\"release_date\":\"2015-07-14\"},{\"vote_count\":471,\"id\":400535,\"video\":false,\"vote_average\":6.7,\"title\":\"Sicario: Day of the Soldado\",\"popularity\":58.846,\"poster_path\":\"\\/msqWSQkU403cQKjQHnWLnugv7EY.jpg\",\"original_language\":\"en\",\"original_title\":\"Sicario: Day of the Soldado\",\"genre_ids\":[28,80,18,53],\"backdrop_path\":\"\\/tnwMCH4yLBY4qpe6Nr4n66u4U3f.jpg\",\"adult\":false,\"overview\":\"Agent Matt Graver teams up with operative Alejandro Gillick to prevent Mexican drug cartels from smuggling terrorists across the United States border.\",\"release_date\":\"2018-06-27\"},{\"vote_count\":66,\"id\":332562,\"video\":false,\"vote_average\":6.5,\"title\":\"A Star Is Born\",\"popularity\":54.27,\"poster_path\":\"\\/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg\",\"original_language\":\"en\",\"original_title\":\"A Star Is Born\",\"genre_ids\":[18,10402,10749],\"backdrop_path\":\"\\/840rbblaLc4SVxm8gF3DNdJ0YAE.jpg\",\"adult\":false,\"overview\":\"Seasoned musician Jackson Maine discovers—and falls in love with—struggling artist Ally. She has just about given up on her dream to make it big as a singer—until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.\",\"release_date\":\"2018-10-03\"},{\"vote_count\":2,\"id\":516710,\"video\":false,\"vote_average\":7.5,\"title\":\"Assalamualaikum Calon Imam\",\"popularity\":53.95,\"poster_path\":\"\\/mKZp2wJzNKMYfDo9e21Dpw0MTmi.jpg\",\"original_language\":\"id\",\"original_title\":\"Assalamualaikum Calon Imam\",\"genre_ids\":[18],\"backdrop_path\":null,\"adult\":false,\"overview\":\"\",\"release_date\":\"2018-06-07\"},{\"vote_count\":8492,\"id\":284053,\"video\":false,\"vote_average\":7.5,\"title\":\"Thor: Ragnarok\",\"popularity\":51.504,\"poster_path\":\"\\/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg\",\"original_language\":\"en\",\"original_title\":\"Thor: Ragnarok\",\"genre_ids\":[28,12,35,14,878],\"backdrop_path\":\"\\/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg\",\"adult\":false,\"overview\":\"Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.\",\"release_date\":\"2017-10-25\"},{\"vote_count\":6806,\"id\":181808,\"video\":false,\"vote_average\":7.1,\"title\":\"Star Wars: The Last Jedi\",\"popularity\":51.345,\"poster_path\":\"\\/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg\",\"original_language\":\"en\",\"original_title\":\"Star Wars: The Last Jedi\",\"genre_ids\":[14,12,878,28],\"backdrop_path\":\"\\/5Iw7zQTHVRBOYpA0V6z0yypOPZh.jpg\",\"adult\":false,\"overview\":\"Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.\",\"release_date\":\"2017-12-13\"}]}";

    private String[] posters = JsonUtils.getPoster(json);

    public interface PosterItemClickListener{
        void onListItemClicked(int clickedItemIndex);
    }

    public PosterAdapter(int numberOfItems, PosterItemClickListener listener, String jsonString)
    {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        //json = jsonString;
       // setPosters(json);
    }

    protected void setPosters()
    {
        posters = JsonUtils.getPoster(json);
    }

    protected void setJson(String jsonString)
    {
        json = jsonString;
        notifyDataSetChanged();
        //setPosters(json);
    }


    /*
    public PosterAdapter(int numberOfItems , String criteria )
    {
        mNumberItems = numberOfItems;
        if (criteria.equals("Most Popular"))
            json = popular;
        else if (criteria.equals("Top Rated"))
            json = topRated;
        else
            json = popular;
        posters = JsonUtils.getPoster(json);

    }
    */

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForItem = R.layout.poster_grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForItem, viewGroup, shouldAttachToParentImmediately);
        PosterViewHolder viewHolder = new PosterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PosterViewHolder holder, int number)
    {
        Log.d(TAG, " " + number + " " + posters[number]);
        holder.bind(posters[number]);
    }

    @Override
    public int getItemCount() { return mNumberItems; }

    public void selectCriteria(String option)
    {
        json = option;
        notifyDataSetChanged();
        setPosters();
    }

    // getter method
    String getJson()
    {
        return json;
    }

    class PosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView gridItemPosterView;

        public PosterViewHolder(View itemView)
        {
            super(itemView);
            gridItemPosterView = (ImageView) itemView.findViewById(R.id.poster_image);
            itemView.setOnClickListener(this);
        }


        void bind(String imageAddress) {
            Picasso.get().load(imageAddress).into(gridItemPosterView);

            /*
            int picture = R.drawable.peanut_day;
            gridItemPosterView.setImageResource(picture);
            */
        }

        @Override
        public void onClick(View v)
        {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClicked(clickedPosition);
        }
    }
}
