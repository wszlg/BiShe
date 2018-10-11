//
//  JMamagerDetailCell.swift
//  Content
//
//  Created by fcn on 2018/10/11.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import AVKit


class JMamagerDetailCell: UITableViewCell {
    
    var player: AVPlayer?
    var playerLayer: AVPlayerLayer?
//    var videourl = ""
    
    
    @IBOutlet weak var videoView: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        
//        let videoUrl = URL(string: videourl)
//        player = AVPlayer(url: videoUrl!)
//        playerLayer = AVPlayerLayer(player: player)
//        playerLayer?.frame = videoView.bounds
//        playerLayer?.videoGravity = .resizeAspectFill
//        videoView.layer.addSublayer(playerLayer!)
        
//        player?.play()
        
    }
    
    var videourl = "" {
        didSet{
            let videoUrl = URL(string: "\(staticURL)\(videourl)")
            player = AVPlayer(url: videoUrl!)
            playerLayer = AVPlayerLayer(player: player)
            playerLayer?.frame = videoView.bounds
            playerLayer?.videoGravity = .resizeAspectFill
            videoView.layer.addSublayer(playerLayer!)
            player?.play()
        }
    }
    

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
