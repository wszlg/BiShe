//
//  MainController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import SnapKit

class MainController: UIViewController, UIScrollViewDelegate {
    
    
    
    @IBOutlet weak var itemControlView: WJItemsControlView!
    
    @IBOutlet weak var scroll: UIScrollView!
    
    
    let SWidth = UIScreen.main.bounds.size.width
    
    
    var childrens = [UIViewController]()
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    
        navigationItem.title = "生活趣事"
        
        let titles = ["新闻", "科技", "人文", "经管", "历史"]
        
        
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
        
        itemControlView.tapItemWithIndex = { [weak self] (index, animation) in
            
            print("点击了 index = \(index)")
            
            self!.scroll.scrollRectToVisible(CGRect(x: CGFloat(index) * (self!.scroll.frame.size.width), y: 0.0, width: self!.scroll.frame.size.width, height: self!.scroll.frame.size.height), animated: animation)
            
            self!.addChildrenVC(child: self!.childrens[index], index: index)
            
        }
        
        
        
        
        
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "NewsViewController") as! NewsViewController
        childrens.append(vc)
        
        let textVC = storyboard.instantiateViewController(withIdentifier: "TextController") as! TextController
        childrens.append(textVC)
        
        let picVC = storyboard.instantiateViewController(withIdentifier: "PicController") as! PicController
        childrens.append(picVC)
        
        
//        childrens.append(TestController())
//        childrens.append(TestController())
//        childrens.append(TestController())
//        childrens.append(TestController())
//        childrens.append(TestController())
        
        
        
        vc.view.frame = CGRect(x: 0, y: 0, width: SWidth - 40, height: scroll.frame.size.height)
        self.addChildViewController(vc)
        scroll.addSubview(vc.view)
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
        
        let index = Int(offset)
        
        print("滑动到 index = \(index)")
        
        
        addChildrenVC(child: childrens[index], index: index)
        
        
        
    }
    
    func addChildrenVC(child: UIViewController, index: Int) {
        if !self.childViewControllers.contains(child) {
            child.view.frame = CGRect(x: SWidth * CGFloat(index), y: 0, width: SWidth, height: scroll.frame.size.height)
            self.addChildViewController(child)
            scroll.addSubview(child.view)
        }
    }
    
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        print("Swidth = \(SWidth)")
        
        print("scrollWidth = \(scroll.frame.size.width)")
    }
    

}
