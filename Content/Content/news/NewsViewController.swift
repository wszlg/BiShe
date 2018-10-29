//
//  NewsViewController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//


// 只有 文字和图片


import UIKit
import MJRefresh
import Alamofire
import SwiftyJSON
import SDCycleScrollView

class NewsViewController: UITableViewController {
    
    
    var datas = [JSON]()
    var pageNo: Int = 1
    

    override func viewDidLoad() {
        super.viewDidLoad()


        tableView.rowHeight = 100
        tableView.mj_footer = MJRefreshAutoNormalFooter(refreshingTarget: self, refreshingAction: #selector(loadMore))
        
        
        
        
        
        let m_parameters: Parameters = [
            "pageNo": pageNo,
            "pageSize": 10
        ]
        NetTool.Get(url: "\(BACKURL)getNews.action", parameters: m_parameters) { (json) in
            if let json = json {
                print(json)
                let data = json["list"].arrayValue
                for item in data {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
            }
        }
        
        
        
        

    
        let headerView = UIView(frame: CGRect(x: 0, y: 0, width: 200, height: 200))
        headerView.backgroundColor = UIColor.red
        tableView.tableHeaderView = headerView
        
        
        
        // 网络加载图片的轮播器
//        SDCycleScrollView *cycleScrollView = [cycleScrollViewWithFrame:frame delegate:delegate placeholderImage:placeholderImage];
//        cycleScrollView.imageURLStringsGroup = imagesURLStrings;

        let imgagesUrls = ["http://cms-bucket.nosdn.127.net/2018/10/29/c9ba993bd6cb41a8902e5f9fa8d0de73.jpeg?imageView&thumbnail=550x0", "http://cms-bucket.nosdn.127.net/catchpic/f/f4/f487a902d41bca65317ea19d611e92a5.jpg?imageView&thumbnail=550x0", "http://pic-bucket.nosdn.127.net/photo/0001/2018-10-29/DV8Q9M4P00AO0001NOS.jpg", "http://cms-bucket.nosdn.127.net/catchpic/e/e5/e515fb5e953ee12379b0d5589f34cc1b.png?imageView&thumbnail=550x0"]
        let cycleScrollView = SDCycleScrollView(frame: headerView.bounds, imageURLStringsGroup: imgagesUrls)
        headerView.addSubview(cycleScrollView!)
        
        
        
    }
    

    
    
    @objc func loadMore()  {
        pageNo += 1
        let m_parameters: Parameters = [
            "pageNo": pageNo,
            "pageSize": 10
        ]
        NetTool.Get(url: "\(BACKURL)getNews.action", parameters: m_parameters) { (json) in
            if let json = json {
                let data = json["list"].arrayValue
                for item in data {
                    self.datas.append(item)
                }
                self.tableView.reloadData()
                self.tableView.mj_footer.endRefreshing()
            }
        }
    }



    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return datas.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "NewsCell", for: indexPath) as! NewsCell

        cell.model = datas[indexPath.row]
        return cell
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
//        print("didSelectRowAt")
        
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "NewsDetailViewController") as! NewsDetailViewController
        vc.model = datas[indexPath.row]
        self.navigationController?.pushViewController(vc, animated: true)
        
        
    }
    




}
