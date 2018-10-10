//
//  NewsDetailCell1.swift
//  Content
//
//  Created by fcn on 2018/10/10.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class NewsDetailCell1: UITableViewCell {
    
    
    @IBOutlet weak var title: UILabel!
    
    @IBOutlet weak var content: UILabel!
    
    @IBOutlet weak var img: UIImageView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
//        title.text = "新京报快讯 10月7日，四川达州一道路发声塌陷，4人坠落后遇难。事后，有网友发微博称，达州再次发生路面塌陷事故。10月9日，达州市公安局网络安全保卫支队辟谣称，并无新增塌方，网上视频系工作人员在抽水作业。 10月7日14时30分左右，四川达州"
//        content.text = "新京报快讯 10月7日，四川达州一道路发声塌陷，4人坠落后遇难。事后，有网友发微博称，达州再次发生路面塌陷事故。10月9日，达州市公安局网络安全保卫支队辟谣称，并无新增塌方，网上视频系工作人员在抽水作业。 10月7日14时30分左右，四川达州"
//
//        img.image = UIImage(named: "test1")
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
