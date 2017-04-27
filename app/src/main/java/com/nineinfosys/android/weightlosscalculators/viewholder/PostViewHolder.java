package com.nineinfosys.android.weightlosscalculators.viewholder;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nineinfosys.android.weightlosscalculators.R;
import com.nineinfosys.android.weightlosscalculators.models.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView authorView;
    public Button likeView;
    public TextView numLikeView;
    public TextView bodyView;
    public Button commentView;
    public Button shareView;
    public TextView time;
    public TextView date;

    public Context context;

    public PostViewHolder(View itemView) {
        super(itemView);


        titleView = (TextView) itemView.findViewById(R.id.post_title);
        authorView = (TextView) itemView.findViewById(R.id.post_author);
        likeView = (Button) itemView.findViewById(R.id.like);
        numLikeView = (TextView) itemView.findViewById(R.id.post_num_likes);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);
        commentView = (Button) itemView.findViewById(R.id.comment);
        shareView = (Button) itemView.findViewById(R.id.share);
        time = (TextView) itemView.findViewById(R.id.post_time);
        date = (TextView) itemView.findViewById(R.id.post_date);

    }

    public void bindToPost(Post post, View.OnClickListener starClickListener) {
        titleView.setText(post.title);
        authorView.setText(post.author);
        numLikeView.setText(String.valueOf(post.likeCount));
        bodyView.setText(post.body);
        time.setText(post.messageTime);
        date.setText(post.messageDate);
        likeView.setOnClickListener(starClickListener);

    }


}
