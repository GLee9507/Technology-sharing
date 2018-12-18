package com.glee.technology_sharing.sample.repository.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author liji
 * @date 2018/12/17 11:33
 * description
 */


public class Movie {

    /**
     * rating : {"max":10,"average":2.7,"details":{"1":27,"3":0,"2":3,"5":2,"4":0},"stars":"15","min":0}
     * reviews_count : 8
     * videos : []
     * wish_count : 199
     * original_title : 恐怖理发店
     * blooper_urls : []
     * collect_count : 347
     * images : {"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2406903891.jpg","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2406903891.jpg","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2406903891.jpg"}
     * douban_site :
     * year : 2017
     * popular_comments : [{"rating":{"max":5,"value":1,"min":0},"useful_count":0,"author":{"uid":"maggie841212","avatar":"http://img7.doubanio.com/icon/u33450230-272.jpg","signature":"一名拉玛西亚青年近卫军","alt":"http://www.douban.com/people/maggie841212/","id":"33450230","name":"笑子大魔王"},"subject_id":"26865690","content":"很不错的片子，评分还可以更低一些，并且有很大的空间","created_at":"2017-02-03 23:06:17","id":"1146632816"},{"rating":{"max":5,"value":1,"min":0},"useful_count":49,"author":{"uid":"150848902","avatar":"http://img7.doubanio.com/icon/u150848902-2.jpg","signature":"","alt":"http://www.douban.com/people/150848902/","id":"150848902","name":"皮卡皮卡皮卡啾"},"subject_id":"26865690","content":"第一部恐怖理发店，第二部恐怖美容院，第三部美甲店，第四部恐怖学校，第五部。。。可以一直拍下去，地老天荒","created_at":"2017-01-06 13:12:37","id":"1132879082"},{"rating":{"max":5,"value":0,"min":0},"useful_count":8,"author":{"uid":"99742301","avatar":"http://img3.doubanio.com/icon/user_normal.jpg","signature":"","alt":"http://www.douban.com/people/99742301/","id":"99742301","name":"文艺不起来"},"subject_id":"26865690","content":"自从看过三五部国产鬼片后 我再也不浪费钱了 现在的国产鬼片一定是用来洗钱的 妈蛋 侮辱观众智商  不看给差评","created_at":"2017-01-09 23:28:18","id":"1134858583"},{"rating":{"max":5,"value":1,"min":0},"useful_count":12,"author":{"uid":"88046629","avatar":"http://img7.doubanio.com/icon/u88046629-4.jpg","signature":"","alt":"http://www.douban.com/people/88046629/","id":"88046629","name":"沉睡的真真真真"},"subject_id":"26865690","content":"我没看过这篇也知道一分，我就是想来问问大家明知道不好看为什么还来看？？（标题写暂无评分是因为分实在太低了吗？）","created_at":"2017-01-09 23:16:31","id":"1134851423"}]
     * alt : https://movie.douban.com/subject/26865690/
     * id : 26865690
     * mobile_url : https://movie.douban.com/subject/26865690/mobile
     * photos_count : 27
     * pubdate : 2017-01-06
     * title : 恐怖理发店
     * do_count : null
     * has_video : false
     * share_url : http://m.douban.com/movie/subject/26865690
     * seasons_count : null
     * languages : ["汉语普通话"]
     * schedule_url : https://movie.douban.com/subject/26865690/cinema/
     * writers : [{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"","name":"纪然","alt":"https://movie.douban.com/celebrity/1366595/","id":"1366595"},{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Shilei Lu","name":"陆诗雷","alt":"https://movie.douban.com/celebrity/1360707/","id":"1360707"}]
     * pubdates : ["2017-01-06(中国大陆)"]
     * website :
     * tags : ["惊悚","一个星都不想给！","烂片","烂片之中的烂片啊~","垃圾","呵呵","MDZZ","中国","真的好恐怖啊！","狗屎"]
     * has_schedule : true
     * durations : ["89分钟"]
     * genres : ["爱情","悬疑","惊悚"]
     * collection : null
     * trailers : [{"medium":"http://img3.doubanio.com/img/trailer/medium/2395934439.jpg?","title":"预告片：正式版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/206905/","small":"http://img3.doubanio.com/img/trailer/small/2395934439.jpg?","resource_url":"http://vt1.doubanio.com/201702180820/994ce6a83c4d28a0eb8b93f8f71fe45a/view/movie/M/302060905.mp4","id":"206905"},{"medium":"http://img3.doubanio.com/img/trailer/medium/2408079427.jpg?1482683047","title":"预告片：终极版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/209536/","small":"http://img3.doubanio.com/img/trailer/small/2408079427.jpg?1482683047","resource_url":"http://vt1.doubanio.com/201702180820/b556b239a4051f4fde74c18379d2beee/view/movie/M/302090536.mp4","id":"209536"},{"medium":"http://img7.doubanio.com/img/trailer/medium/2406384532.jpg?","title":"预告片：激情版 (中文字幕)","subject_id":"26865690","alt":"https://movie.douban.com/trailer/209076/","small":"http://img7.doubanio.com/img/trailer/small/2406384532.jpg?","resource_url":"http://vt1.doubanio.com/201702180820/ddaaf1f51061b7b16d84429b29e373b9/view/movie/M/302090076.mp4","id":"209076"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201702180820/994ce6a83c4d28a0eb8b93f8f71fe45a/view/movie/M/302060905.mp4","http://vt1.doubanio.com/201702180820/b556b239a4051f4fde74c18379d2beee/view/movie/M/302090536.mp4","http://vt1.doubanio.com/201702180820/ddaaf1f51061b7b16d84429b29e373b9/view/movie/M/302090076.mp4"]
     * has_ticket : true
     * bloopers : []
     * clip_urls : []
     * current_season : null
     * casts : [{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1403756298.69.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1403756298.69.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1403756298.69.jpg"},"name_en":"Guoer Yin","name":"殷果儿","alt":"https://movie.douban.com/celebrity/1340984/","id":"1340984"},{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Qingan Ren","name":"任青安","alt":"https://movie.douban.com/celebrity/1359164/","id":"1359164"},{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1451209491.55.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1451209491.55.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1451209491.55.jpg"},"name_en":"SungGoo Kang","name":"姜星丘","alt":"https://movie.douban.com/celebrity/1353667/","id":"1353667"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1478601324.49.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1478601324.49.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1478601324.49.jpg"},"name_en":"Jiamin Chen","name":"陈嘉敏","alt":"https://movie.douban.com/celebrity/1340988/","id":"1340988"}]
     * countries : ["中国大陆"]
     * mainland_pubdate : 2017-01-06
     * photos : [{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2406383762.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2406383762.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2406383762.jpg","alt":"https://movie.douban.com/photos/photo/2406383762/","id":"2406383762","icon":"http://img7.doubanio.com/view/photo/icon/public/p2406383762.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2411789707.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2411789707.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2411789707.jpg","alt":"https://movie.douban.com/photos/photo/2411789707/","id":"2411789707","icon":"http://img3.doubanio.com/view/photo/icon/public/p2411789707.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2411789702.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2411789702.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2411789702.jpg","alt":"https://movie.douban.com/photos/photo/2411789702/","id":"2411789702","icon":"http://img7.doubanio.com/view/photo/icon/public/p2411789702.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2411789693.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2411789693.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2411789693.jpg","alt":"https://movie.douban.com/photos/photo/2411789693/","id":"2411789693","icon":"http://img7.doubanio.com/view/photo/icon/public/p2411789693.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2408074732.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2408074732.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2408074732.jpg","alt":"https://movie.douban.com/photos/photo/2408074732/","id":"2408074732","icon":"http://img7.doubanio.com/view/photo/icon/public/p2408074732.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2408074723.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2408074723.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2408074723.jpg","alt":"https://movie.douban.com/photos/photo/2408074723/","id":"2408074723","icon":"http://img7.doubanio.com/view/photo/icon/public/p2408074723.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2408074715.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2408074715.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2408074715.jpg","alt":"https://movie.douban.com/photos/photo/2408074715/","id":"2408074715","icon":"http://img7.doubanio.com/view/photo/icon/public/p2408074715.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2406383761.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2406383761.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2406383761.jpg","alt":"https://movie.douban.com/photos/photo/2406383761/","id":"2406383761","icon":"http://img7.doubanio.com/view/photo/icon/public/p2406383761.jpg"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p2406383759.jpg","image":"http://img3.doubanio.com/view/photo/photo/public/p2406383759.jpg","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p2406383759.jpg","alt":"https://movie.douban.com/photos/photo/2406383759/","id":"2406383759","icon":"http://img3.doubanio.com/view/photo/icon/public/p2406383759.jpg"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p2395927790.jpg","image":"http://img7.doubanio.com/view/photo/photo/public/p2395927790.jpg","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p2395927790.jpg","alt":"https://movie.douban.com/photos/photo/2395927790/","id":"2395927790","icon":"http://img7.doubanio.com/view/photo/icon/public/p2395927790.jpg"}]
     * summary : 位于深山小镇的理发店发生的一系列灵异奇闻，殷果儿、任青安、姜星丘等人陷入危难绝境中无法脱身，和理发店有关联的人物接连被惨绝杀害，血腥残暴引来人心惶惶，而抽丝剥茧之后的真相更加令人心惊胆战。
     * clips : []
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Shilei Lu","name":"陆诗雷","alt":"https://movie.douban.com/celebrity/1360707/","id":"1360707"}]
     * comments_count : 191
     * popular_reviews : [{"rating":{"max":5,"value":1,"min":0},"title":"国产恐怖片，注定成烂片？","subject_id":"26865690","author":{"uid":"123404248","avatar":"http://img7.doubanio.com/icon/u123404248-3.jpg","signature":"","alt":"http://www.douban.com/people/123404248/","id":"123404248","name":"世界奇妙物语"},"summary":"这一系列国产恐怖片太多，现在总结下国产电影拍摄门槛为什么这么低\u2026\u2026 1.找个导演，内地导演优先考虑(省钱)。 2.去网上热搜榜（也是经纪公司）上挑几个网红明星（省钱）。网红明星就像木偶一样被装扮上了。 3.去...","alt":"https://movie.douban.com/review/8301338/","id":"8301338"}]
     * ratings_count : 318
     * aka : ["Ghost in Barber's"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<?> videos;
    private List<?> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<?> bloopers;
    private List<?> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<?> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<?> getVideos() {
        return videos;
    }

    public void setVideos(List<?> videos) {
        this.videos = videos;
    }

    public List<?> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<?> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<?> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<?> bloopers) {
        this.bloopers = bloopers;
    }

    public List<?> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<?> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<?> getClips() {
        return clips;
    }

    public void setClips(List<?> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 2.7
         * details : {"1":27,"3":0,"2":3,"5":2,"4":0}
         * stars : 15
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 27
             * 3 : 0
             * 2 : 3
             * 5 : 2
             * 4 : 0
             */

            @SerializedName("1")
            private int _$1;
            @SerializedName("3")
            private int _$3;
            @SerializedName("2")
            private int _$2;
            @SerializedName("5")
            private int _$5;
            @SerializedName("4")
            private int _$4;

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }

            public int get_$3() {
                return _$3;
            }

            public void set_$3(int _$3) {
                this._$3 = _$3;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }

            public int get_$5() {
                return _$5;
            }

            public void set_$5(int _$5) {
                this._$5 = _$5;
            }

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2406903891.jpg
         * large : http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2406903891.jpg
         * medium : http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2406903891.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":1,"min":0}
         * useful_count : 0
         * author : {"uid":"maggie841212","avatar":"http://img7.doubanio.com/icon/u33450230-272.jpg","signature":"一名拉玛西亚青年近卫军","alt":"http://www.douban.com/people/maggie841212/","id":"33450230","name":"笑子大魔王"}
         * subject_id : 26865690
         * content : 很不错的片子，评分还可以更低一些，并且有很大的空间
         * created_at : 2017-02-03 23:06:17
         * id : 1146632816
         */

        private RatingBeanX rating;
        private int useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5
             * value : 1
             * min : 0
             */

            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : maggie841212
             * avatar : http://img7.doubanio.com/icon/u33450230-272.jpg
             * signature : 一名拉玛西亚青年近卫军
             * alt : http://www.douban.com/people/maggie841212/
             * id : 33450230
             * name : 笑子大魔王
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
         * name_en :
         * name : 纪然
         * alt : https://movie.douban.com/celebrity/1366595/
         * id : 1366595
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
             * large : http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
             * medium : http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class TrailersBean {
        /**
         * medium : http://img3.doubanio.com/img/trailer/medium/2395934439.jpg?
         * title : 预告片：正式版 (中文字幕)
         * subject_id : 26865690
         * alt : https://movie.douban.com/trailer/206905/
         * small : http://img3.doubanio.com/img/trailer/small/2395934439.jpg?
         * resource_url : http://vt1.doubanio.com/201702180820/994ce6a83c4d28a0eb8b93f8f71fe45a/view/movie/M/302060905.mp4
         * id : 206905
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/1403756298.69.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1403756298.69.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1403756298.69.jpg"}
         * name_en : Guoer Yin
         * name : 殷果儿
         * alt : https://movie.douban.com/celebrity/1340984/
         * id : 1340984
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : http://img3.doubanio.com/img/celebrity/small/1403756298.69.jpg
             * large : http://img3.doubanio.com/img/celebrity/large/1403756298.69.jpg
             * medium : http://img3.doubanio.com/img/celebrity/medium/1403756298.69.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PhotosBean {
        /**
         * thumb : http://img7.doubanio.com/view/photo/thumb/public/p2406383762.jpg
         * image : http://img7.doubanio.com/view/photo/photo/public/p2406383762.jpg
         * cover : http://img7.doubanio.com/view/photo/albumcover/public/p2406383762.jpg
         * alt : https://movie.douban.com/photos/photo/2406383762/
         * id : 2406383762
         * icon : http://img7.doubanio.com/view/photo/icon/public/p2406383762.jpg
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
         * name_en : Shilei Lu
         * name : 陆诗雷
         * alt : https://movie.douban.com/celebrity/1360707/
         * id : 1360707
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanXX {
            /**
             * small : http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
             * large : http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
             * medium : http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":1,"min":0}
         * title : 国产恐怖片，注定成烂片？
         * subject_id : 26865690
         * author : {"uid":"123404248","avatar":"http://img7.doubanio.com/icon/u123404248-3.jpg","signature":"","alt":"http://www.douban.com/people/123404248/","id":"123404248","name":"世界奇妙物语"}
         * summary : 这一系列国产恐怖片太多，现在总结下国产电影拍摄门槛为什么这么低…… 1.找个导演，内地导演优先考虑(省钱)。 2.去网上热搜榜（也是经纪公司）上挑几个网红明星（省钱）。网红明星就像木偶一样被装扮上了。 3.去...
         * alt : https://movie.douban.com/review/8301338/
         * id : 8301338
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanXX {
            /**
             * max : 5
             * value : 1
             * min : 0
             */

            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : 123404248
             * avatar : http://img7.doubanio.com/icon/u123404248-3.jpg
             * signature :
             * alt : http://www.douban.com/people/123404248/
             * id : 123404248
             * name : 世界奇妙物语
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
