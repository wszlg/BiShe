//
//  MainController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class MainController: UIViewController, UIScrollViewDelegate {
    
    
    
    @IBOutlet weak var itemControlView: WJItemsControlView!
    
    @IBOutlet weak var scroll: UIScrollView!
    
    
    let SWidth = UIScreen.main.bounds.size.width
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    
        navigationItem.title = "生活趣事"
        
        let titles = ["新闻", "房产", "体育", "美女", "文化", "历史", "故事", "汽车"]
        
        
        //头部控制的segMent
        let config = WJItemsConfig()
        config.itemWidth = Float(UIScreen.main.bounds.size.width / 4.0)
        
        itemControlView.tapAnimation = true
        itemControlView.config = config;
        itemControlView.titleArray = titles
        
        scroll.delegate = self;
        scroll.isPagingEnabled = true
        scroll.contentSize = CGSize(width: CGFloat(titles.count) * SWidth, height: 100)
        
//        NSInteger index,BOOL animation
        
        itemControlView.tapItemWithIndex = { (index, animation) in
            
            self.scroll.scrollRectToVisible(CGRect(x: CGFloat(index) * self.scroll.frame.size.width, y: 0.0, width: self.scroll.frame.size.width, height: self.scroll.frame.size.height), animated: animation)
            
//        [weakScrollView scrollRectToVisible:CGRectMake(index*weakScrollView.frame.size.width, 0.0, weakScrollView.frame.size.width,weakScrollView.frame.size.height) animated:animation];
            
        }
        
        
        
    }


    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        var offset = scrollView.contentOffset.x
        offset = offset / scrollView.frame.size.width
        itemControlView.move(toIndex: Float(offset))
    }
    
    func scrollViewDidEndDecelerating(_ scrollView: UIScrollView) {
        var offset = scrollView.contentOffset.x
        offset = offset / scrollView.frame.size.width
        itemControlView.endMove(toIndex: Float(offset))
        
    }

}
