const search = document.querySelector(".search-container");
const search_box = document.querySelector(".search-box");
const search_input = document.querySelector("#search-in");
const img = search_box.querySelector("img");
const recommend = document.querySelector('.recommend');
const m_content_box = document.querySelector('.m-content-box');



window.onload = (event) => {
    recommend_fixed(event);
    for (let i = 0; i < 2; i++){
        add_article_tag();
    }
}
window.onresize = recommend_fixed;

function recommend_fixed(event) {
    recommend.style.left = `${642 + (event.currentTarget.innerWidth - 952) / 2}px`;
}

search.onclick = () => {
    if (search_input.value.length == 0) {
        search_box.removeChild(img);
    }
    if (search_input.focus()) {
        if (search_input.value.length != 0) {
            search_box.removeChild(label);
        }
    }
    else {
        
    }
}

function add_article_tag() {
    const article_box = document.createElement('div');
    article_box.className = 'article-box';
    article_box.innerHTML = `
                        <div class="feed-username-box">
                            <div class="feed-header">
                                <div class="header-img-box">
                                    <img src="images/profile.PNG">
                                </div>
                                <div class="feed-username">
                                    <a href="#">gye0un_un</a>
                                    <span>Arizona Zervas•FML</span>
                                </div>
                            </div>
                            <div class="dot-img">
                                <i class="fa-solid fa-ellipsis" style="font-size: 17px;"></i>
                            </div>
                        </div>
                        <div class="article-content">

                        </div>
                        <div class="comment-box">
                            <div class="reaction-box">
                                <div>
                                    <button><i class="fa-regular fa-heart"></i></button>
                                </div>
                                <div>
                                    <button><i class="fa-regular fa-comment"></i></button>
                                </div>
                                <div>
                                    <button><i class="fa-regular fa-paper-plane"></i></button>
                                </div>
                                <div>
                                    <button><i class="fa-regular fa-bookmark"></i></button>
                                </div>
                                
                            </div>
                            <div class="like-count">
                                <img src="images/profile.PNG">
                                <span><b style="font-weight: 500;">gye0ng_un</b>님 외&nbsp;<b style="font-weight: 500;">여러명</b>이 좋아합니다</span>
                            </div>
                            <div class="comment-items">

                            </div>
                            <div class="feed-time">
                                <span>1시간 전</span>
                            </div>
                            <div class="to-comment">
                                <div class="to-comment-img-box">
                                    <i class="fa-regular fa-face-smile"></i>
                                </div>
                                <div class="comment-text">
                                    <input type="text" id="comment" placeholder="댓글 달기...">
                                </div>
                                <button class="posting">
                                    게시
                                </button>
                            </div>
                        </div>
    `
    m_content_box.appendChild(article_box);
}
