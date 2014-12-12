package com.jefflinwood.util;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jefflinwood.parseitemtableview.R;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by jlinwood on 12/12/14.
 */
public class ParseItemPositionQueryAdapter extends BaseAdapter{
    ContainedParseQueryAdapter mParseQueryAdapter;
    Context mContext;

    public ParseItemPositionQueryAdapter(Context context,Class<? extends ParseObject> clazz) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,clazz);
        mContext = context;
    }


    public ParseItemPositionQueryAdapter(Context context,Class<? extends ParseObject> clazz, int itemViewResource) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,clazz,itemViewResource);
        mContext = context;
    }


    public ParseItemPositionQueryAdapter(Context context,ParseQueryAdapter.QueryFactory queryFactory) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,queryFactory);
        mContext = context;
    }

    public ParseItemPositionQueryAdapter(Context context,ParseQueryAdapter.QueryFactory queryFactory, int itemViewResource) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,queryFactory,itemViewResource);
        mContext = context;
    }

    public ParseItemPositionQueryAdapter(Context context,String className) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,className);
        mContext = context;
    }

    public ParseItemPositionQueryAdapter(Context context, String className, int itemViewResource) {
        mParseQueryAdapter = new ContainedParseQueryAdapter(context,className,itemViewResource);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mParseQueryAdapter.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mParseQueryAdapter.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return mParseQueryAdapter.getItemId(position);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mParseQueryAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mParseQueryAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ParseObject parseObject = (ParseObject) getItem(position);
        return getItemView(position, parseObject,convertView,parent);
    }



    public View getItemView(int position,
                            ParseObject parseObject,
                            View v,
                            ViewGroup parent) {
        if (v == null) {
            v = View.inflate(mContext, R.layout.row_item, null);
        }

        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        nameTextView.setText(parseObject.getString("name"));

        if (position % 2 == 0) {
            v.setBackgroundColor(mContext.getResources().getColor(android.R.color.darker_gray));
        }

        return v;

    }



    class ContainedParseQueryAdapter extends ParseQueryAdapter {
        public ContainedParseQueryAdapter(Context context, Class clazz) {
            super(context, clazz);
        }

        public ContainedParseQueryAdapter(Context context, String className) {
            super(context, className);
        }

        public ContainedParseQueryAdapter(Context context, Class clazz, int itemViewResource) {
            super(context, clazz, itemViewResource);
        }

        public ContainedParseQueryAdapter(Context context, String className, int itemViewResource) {
            super(context, className, itemViewResource);
        }

        public ContainedParseQueryAdapter(Context context, QueryFactory queryFactory) {
            super(context, queryFactory);
        }

        public ContainedParseQueryAdapter(Context context, QueryFactory queryFactory, int itemViewResource) {
            super(context, queryFactory, itemViewResource);
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ParseItemPositionQueryAdapter.this.notifyDataSetChanged();
        }

        @Override
        public void notifyDataSetInvalidated() {
            super.notifyDataSetInvalidated();
            ParseItemPositionQueryAdapter.this.notifyDataSetInvalidated();
        }
    }
}
